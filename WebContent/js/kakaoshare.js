
Kakao.init('e96f1d92ff003a894eb89f40ef010bd0');
Kakao.isInitialized();

function sendlink(){
	var sharetitle = shareform.title.value;
	var sharecontent = shareform.content.value;
	var imgurl = shareform.imgUrl.value;
	let currenturl = window.document.location.href;
	Kakao.Link.sendDefault({
		objectType: 'feed',
		content: {
			title: sharetitle,
			description: sharecontent,
			imageUrl:
				imgurl,
			link: {
				mobileWebUrl: currenturl,
				webUrl:currenturl
			},
		},
	});
};