# Students and Examinations

```sql
with group_exam as (
    select 
        student_id,
        subject_name,
        count(*) as 'attended_exams'
    from
        Examinations
    group by
        student_id,
        subject_name)

select
    s.student_id,
    s.student_name,
    sub.subject_name,
    ifnull(group_exam.attended_exams, 0) as 'attended_exams'
from
    Students s cross join Subjects sub
    left join group_exam
    on group_exam.student_id = s.student_id and
    group_exam.subject_name = sub.subject_name
order by
    1,
    3
```
