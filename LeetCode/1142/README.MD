# User Activity for the Past 30 Days II

```sql
select ifnull(round(count(distinct session_id)/
                    count(distinct user_id)
            ,2)
        , 0.00) as 'average_sessions_per_user'
from
    Activity
where
    activity_date <= '2019-07-27' and
    activity_date >= '2019-06-28'
```
