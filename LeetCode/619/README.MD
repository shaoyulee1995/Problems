# Biggest Single Number

```sql
with max_single as (
    select 
        num
    from
        MyNumbers
    group by
        1
    having count(*) = 1)

select 
    max(num) as 'num'
from 
    max_single
```
