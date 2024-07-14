# Number of Unique Subjects Taught by Each Teacher

```sql
select
    teacher_id,
    count(distinct subject_id) as 'cnt'
from
    Teacher
group by
    1
```
