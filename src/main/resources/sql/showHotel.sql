---已知hotelId，checkIn，checkOut 求[in,out]时间段内hotelId下有余量的房间信息
select *
from (
      /* 查找[in,out]时间段内某房间被占用间数 */
      select r0.id AS remainderId, (r0.count - ifnull(occupied,0)) * r0.capacity AS remainderCap
      from (
               select rooms.id, count(reserves.id) AS occupied
               from rooms LEFT JOIN reserves on reserves.roomId = rooms.id
               where (( "2020-06-14">=reserves.checkInAt and reserves.checkOutAt >= "2020-06-14") OR
                      (reserves.checkInAt >= "2020-06-14" and reserves.checkInAt <= "2020-06-21"))
               group by reserves.roomId
           ) AS occupiedTable RIGHT JOIN rooms AS r0 ON occupiedTable.id = r0.id
  ) AS remainderTable INNER JOIN rooms ON  remainderTable.remainderId = rooms.id and remainderCap>0 and rooms.hotelId=2616;

<select id="findRooms" resultType="com.wxwl.hotelbooking.common.domain.Rooms">
select id,name,price,capacity,intro,count,createdAt,hotelId
from
    (
        select r0.id AS remainderId, (r0.count - ifnull(occupied,0)) * r0.capacity AS remainderCap
        from (
                 select rooms.id, count(reserves.id) AS occupied
                 from rooms LEFT JOIN reserves on reserves.roomId = rooms.id
                 where (( #{checkIn}>=reserves.checkInAt and reserves.checkOutAt >= #{checkIn}) OR
                        (reserves.checkInAt >= #{checkIn} and reserves.checkInAt <= #{checkOut}))
                 group by reserves.roomId
             ) AS occupiedTable RIGHT JOIN rooms AS r0 ON occupiedTable.id = r0.id
    ) AS remainderTable INNER JOIN rooms ON  remainderTable.remainderId = rooms.id and remainderCap>0 and rooms.hotelId=#{hotelId};
</select>


select *
from (
    select *
    from hotels
    WHERE hotelId=1297
) AS ta LEFT JOIN chains ON ta.chainId=chains.chainId
LEFT JOIN brands ON ta.brandId=brands.brandId;


