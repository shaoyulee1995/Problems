# Friendly Movies Streamed Last Month

```sql
select
    distinct title
from
    TVProgram tvp join Content c
    on tvp.content_id = c.content_id
where
    c.content_type = 'Movies' and
    c.Kids_content = 'Y' and
    Year(tvp.program_date) = 2020 and
    Month(tvp.program_date) = 6
```
