# Write your MySQL query statement below
select users.user_id as buyer_id, users.join_date,
    count(
    case 
        when year(orders.order_date)=2019 then orders.buyer_id
        else null
        end
    ) as orders_in_2019
    from users
    left join orders on users.user_id = orders.buyer_id
    group by users.user_id
    
    