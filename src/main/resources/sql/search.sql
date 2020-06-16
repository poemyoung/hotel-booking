SELECT DISTINCT ta.hotelId,chainName,brandName,hotelName,hotelFormerlyName,
hotelTranslatedName,address,zipcode,starRating,longitude,latitude,checkin,
checkout,numberRooms,numberFloors,yearOpened,yearRenovated,photoOne,
photoTwo,photoThree,photoFour,photoFive,overview
minPrice,numberOfReviews,averageRating
FROM
(SELECT hotels.hotelId,chainId,brandId,hotelName,hotelFormerlyName,
hotelTranslatedName,address,zipcode,starRating,longitude,latitude,checkin,
checkout,numberRooms,numberFloors,yearOpened,yearRenovated,photoOne,
photoTwo,photoThree,photoFour,photoFive,overview,
minPrice,numberOfReviews,averageRating FROM hotels
WHERE hotels.hotelId IN (1297,2616,8363)) ta --该List是根据名称查出来的酒店列表，用foreach迭代
LEFT JOIN chains
ON chains.chainId = ta.chainId
LEFT JOIN brands
ON brands.brandId = ta.brandId
NATURAL JOIN
(
 SELECT hotelId FROM
(SELECT rooms.id,rooms.hotelId,
IF((rooms.count-roomsOccupied) * capacity IS NULL,rooms.count * rooms.capacity,(rooms.count-roomsOccupied) * capacity)
 AS roomCap
    FROM rooms LEFT JOIN
    (SELECT reserves.roomId,count(reserves.id) as roomsOccupied FROM reserves
    WHERE
		(#{checkIn} < reserves.checkInAt AND #{checkOut} > reserves.checkInAt)
		OR
		(#{checkIn} > reserves.checkInAt AND #{checkOut} < reserves.checkOutAt)
    GROUP BY reserves.roomId) tb
    ON rooms.id = tb.roomId ) t GROUP BY t.hotelId HAVING SUM(roomCap) > #{numOfCustomers}
) tc;