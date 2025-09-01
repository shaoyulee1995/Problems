# Find Cities in Each State

```sql
select
    state, 
    group_concat(city order by city separator ', ') as 'cities'
from
    cities
group by
    1
order by
    1 asc
```