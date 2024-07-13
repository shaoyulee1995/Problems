# Class Performance

```sql
with t as (
    select
        student_id,
        student_name,
        assignment1 + assignment2 + assignment3 as 'sum'
    from
        Scores
)


select
    max(t.sum) - min(t.sum) as 'difference_in_score'
from 
    t
```
