# Count Artist Occurrences On Spotify Ranking List

```sql
select
    artist,
    count(*) as 'occurrences'
from
    Spotify
group by
    1
order by
    2 desc,
    1 asc
```