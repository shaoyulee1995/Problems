# Find Candidates for Data Scientist Position

```sql
select
    candidate_id
from
    Candidates
where
    skill in ('Python', 'Tableau', 'PostgreSQL')
group by 
    1
having 
    count(skill) = 3
order by
    1
```