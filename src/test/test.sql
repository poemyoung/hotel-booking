
select distinct hotels.hotelId,hotels.hotelName,chainName,brandName
from hotels,chains,brands,rooms
where hotels.hotelId IN(1297,2616,8363) and hotels.chainId=chains.chainId and hotels.brandId=brands.brandId and
rooms.hotelId=hotels.hotelId and (
select r1.totalCapacity-r2.occupiedCapacity As remainderCapacity
from
(   select 1 As common_key,sum(capacity*count) As totalCapacity
    from rooms
    where rooms.hotelId IN(1297,2616,8363)
) As r1
JOIN
(   select 1 As common_key,ifnull(sum(capacity),0) As occupiedCapacity
    from rooms,reserve
    where rooms.hotelId IN(1297,2616,8363)  and (rooms.id=reserve.roomId and
    ((reserve.checkInAt<"2020-06-14" and reserve.checkOutAt>="2020-06-14")or
    (reserve.checkInAt>="2020-06-14" and reserve.checkInAt<="2020-06-23")))
)As r2 ON r1.common_key=r2.common_key
) >= 5;



//获取某酒店id:1297剩余容量
select r1.hotelId,totalCapacity,occupiedCapacity,r1.totalCapacity-r2.occupiedCapacity As remainderCapacity
from
(   select 1 As common_key,rooms.hotelId,sum(capacity*count) As totalCapacity
    from rooms
    where rooms.hotelId IN(1297,2616,8363)
) As r1
JOIN
(   select 1 As common_key,rooms.hotelId,ifnull(sum(capacity),0) As occupiedCapacity
    from rooms,reserve
    where rooms.hotelId IN(1297,2616,8363) and (rooms.id=reserve.roomId and
    ((reserve.checkInAt<"2020-06-14" and reserve.checkOutAt>="2020-06-14")or
    (reserve.checkInAt>="2020-06-14" and reserve.checkInAt<="2020-06-23")))
)As r2 ON r1.hotelId=r2.hotelId;


select r1.totalCapacity-r2.occupiedCapacity As remainderCapacity
from
(   select 1 As common_key,sum(capacity*count) As totalCapacity
    from rooms
    where rooms.hotelId=#{hotelList.get(i).getHotelId()}
) As r1
JOIN
(   select 1 As common_key,ifnull(sum(capacity),0) As occupiedCapacity
    from rooms,reserve
    where rooms.hotelId=hotelList.get(i).getHotelId() and (rooms.id=reserve.roomId and
    ((reserve.checkInAt<#{checkIn} and reserve.checkOutAt>=#{checkIn})or
    (reserve.checkInAt>=#{checkIn} and reserve.checkInAt<=#{checkOut})))
)As r2 ON r1.common_key=r2.common_key and r1.hotelId=r2.hotelId;


