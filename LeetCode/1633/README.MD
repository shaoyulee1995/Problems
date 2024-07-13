# Percentage of Users Attended a Contest

```sql
select
    contest_id,
    round(100*count(r.user_id)/(select count(user_id) from users), 2) as 'percentage'
from
    Register r join Users u
    using(user_id)
group by
    1
order by 
    2 desc,
    1 asc
```