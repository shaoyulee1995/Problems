```
select
    p.session_id
from
    Playback p left join Ads a
    on p.customer_id = a.customer_id and 
    a.timestamp between p.start_time and p.end_time
where
    a.customer_id is NULL    
```