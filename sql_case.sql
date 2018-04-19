   select
      video_id, v.customer_id, video_url, video_cover, cover_height, cover_width, tag_id, 
    tag_name, order_id, view_num,create_time,content_txt
    ,cu.city,cu.customer_head,cu.customer_name,
	(SELECT COUNT(video_id) from ym_cu_video_comment  c
	WHERE  c.video_id=v.video_id ) comment_num,
	(
	SELECT COUNT(cole.collection_id) from ym_cu_vd_collect cole
	  WHERE  cole.video_id=v.video_id
	) collect_num,
	( SELECT COUNT(lk.like_id) from ym_cu_like lk
	WHERE lk.like_type=3
	AND lk.like_to_id=v.video_id
	)like_num 

 	,
	( CASE   when ( SELECT COUNT(lk.like_id) from ym_cu_like lk WHERE lk.like_type=3 AND lk.like_to_id=v.video_id AND lk.customer_id=36 )=0 then 2 
	ELSE 1 END) isLiked,
	( CASE   when ( SELECT COUNT(fl.follow_id) from ym_cu_follow fl WHERE fl.follow_type=1 AND fl.follow_to_id=v.customer_id AND fl.follow_from_id=36 )=0 then 2 
	ELSE 1 END) isFollowed,
	( CASE   when (SELECT COUNT(cole.collection_id) from ym_cu_vd_collect cole
	WHERE  cole.video_id=v.video_id AND cole.customer_id=36)=0 then 2 
	ELSE 1 END) isCollected  

    from ym_cu_video v
    INNER JOIN ym_cu_customer cu ON cu.customer_id=v.customer_id

    ORDER    BY v.video_id DESC	
