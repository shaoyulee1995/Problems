# Sort the Olympic Table

```sql
select
    *
from
    Olympic
order by
    gold_medals desc,
    silver_medals desc,
    bronze_medals desc,
    country asc
```