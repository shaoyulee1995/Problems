# Low-Quality Problems

```
with t as (
    select
        problem_id,
        likes*100/(likes+dislikes) as rate
    from
        Problems)

select
    problem_id
from
    t
where
    rate < 60
order by
    1
```

```
select
    problem_id
from
    Problems
where
    likes/(dislikes+likes) < 0.6
order by
    problem_id
```
