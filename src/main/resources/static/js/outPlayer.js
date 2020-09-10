let index = { // 등록하기 
   init: function(e){ // 이벤트 리스너 바인딩
      $(".btn-outline-dark").on("click", (e) => { // ()안에 아무 변수가 들어가도 콜백시 그 자리에 오브젝트가 들어감
         this.insertById(e);
      });
   },
   insertById: function(e){ // outplayer 등록
	   let checkId = e.target.id.replace("insert_", "");
	   console.log(checkId);
	   
	   
	   let data = {
			   reason :$('#reason_'+checkId).val(),
			   playerId : e.target.id.replace("insert_", "")
	   }
	   console.log('data = ',data)
	   
	   $.ajax({
         type:"POST",
         url:"/baseball/outPlayer/save", 
         contentType: "application/json; charset=utf-8",
         data:JSON.stringify(data),
         dataType: "text"// 서버로부터 응답받을 때 데이터 타입,
      }).done(function(){ 
    		 alert("등록이 완료되었습니다..");
    		 location.href="/baseball/outplayer";
      }).fail(function(error){ // 실패시 ajax 통신이 안된 것
 		 alert("등록에 실패했습니다.");
         console.log(error);   
         console.log("url ::: "+ url);
      })
   }// insertById
};



index.init();