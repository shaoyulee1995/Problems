# Total Traveled Distance

```sql
select
    u.user_id,
    u.name,
    ifnull(sum(r.distance), 0) as 'traveled distance'
from
    Users u left join Rides r
    using(user_id)
group by
    1
order by
    1
```
