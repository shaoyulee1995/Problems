```
select 
    distinct c1.user_id
from
    Confirmations c1 join Confirmations c2
    on c1.user_id = c2.user_id and c1.time_stamp < c2.time_stamp 
where
    timestampdiff(second, c1.time_stamp, c2.time_stamp) <= 86400
```