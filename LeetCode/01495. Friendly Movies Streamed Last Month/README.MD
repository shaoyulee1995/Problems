```
select distinct c.title
from Content c join TVProgram p
    on c.content_id = p.content_id
where c.Kids_content = 'Y' and
    c.content_type = 'Movies' and
    Month(p.program_date) = 6 and
    Year(p.program_date) = 2020;

```