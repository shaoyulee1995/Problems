# Bikes Last Time Used

```sql
select
    bike_number,
    max(end_time) as 'end_time'
from
    Bikes
group by
    bike_number
```
