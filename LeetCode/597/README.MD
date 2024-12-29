# Friend Requests I: Overall Acceptance Rate

```sql
with 
    AcceptedRequests as (
        select count(distinct requester_id, accepter_id) as accepted_count
        from RequestAccepted
    ),
    FriendRequests as (
        select count(distinct sender_id, send_to_id) as friend_count
        from FriendRequest
    )
select 
    round(
        ifnull(
            case 
                when (select friend_count from FriendRequests) = 0 then 0
                else (select accepted_count from AcceptedRequests) / (select friend_count from FriendRequests)
            end, 0), 
        2) as 'accept_rate'
```
