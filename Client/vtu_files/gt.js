function analyticsEvent(eventCategory, eventName) {
	_gaq.push(['_WSG2._trackEvent', eventCategory, eventName, '']);
	_gaq.push(['_WSG._trackEvent', eventCategory, eventName, '']);
}

function analyticsEventCallback(eventCategory, eventName) {
	_gaq.push(['_WSG2._trackEvent', eventCategory, eventName, '']);
	_gaq.push(['_WSG._trackEvent', eventCategory, eventName, '']);
        toaster_incredibar.WSG_return_last_page();
}

var _WSG_gtQueryParam = _WSG_getLocalStore("WSG_gtQueryParam"); 

var _gaq = _gaq || [];

if(_WSG_gtQueryParam){
	_gaq.push(['_WSG._setAccount', _WSG_gtQueryParam]);
	_gaq.push(['_WSG._trackPageview']);
}
_gaq.push(['_WSG2._setAccount', 'UA-25126657-15']);
_gaq.push(['_WSG2._trackPageview']);

(function() {
	var ga = document.createElement('script');     ga.type = 'text/javascript'; ga.async = true;
	ga.src = ('https:'   == document.location.protocol ? 'https://ssl'   : 'http://www') + '.google-analytics.com/ga.js';
	var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
})();
var WSG_createDailyPing = function(){
    var localStore = 'WSG_dailyPing';
    var localStoreString = 'WSG_dailyPing_' + _WSG_getLocalStore('WSG_status');
    if (_WSG_getLocalStore(localStore) == null) {
       // analyticsEvent('WSG_Ping', localStore);
	   _gaq.push(['_WSG._trackEvent', 'WSG_Ping', localStoreString, '']);
	   _gaq.push(['_WSG2._trackEvent', 'WSG_Ping', localStoreString, '']);
        _WSG_setLocalStore(localStore, 'true', 1);
    }
};

var WSG_createInstalledPing = function(){
    var localStore = 'WSG_installedPing';
    if (_WSG_getLocalStore(localStore) == null) {
        //analyticsEvent('WSG_Ping', localStore)
		_gaq.push(['_WSG._trackEvent', 'WSG_Ping', localStore, '']);
		_gaq.push(['_WSG2._trackEvent', 'WSG_Ping', localStore, '']);
        _WSG_setLocalStore(localStore, 'true', 0);
    }
};

WSG_createDailyPing();
WSG_createInstalledPing();