var Template = function () {
    Component.apply(this, arguments);
    var self = this;
    
    var mapData = {};
    var mapSize = {};
    
    function testDevice(){
        if(/Android|webOS|iPhone|iPad|iPod|BlackBerry/i.test(navigator.userAgent)) {
            return true;
        }else{
            return false;
        }
    }
    
    self.initMap = function(data){
    	console.log("INIT MAP!!@!");
    	var params = JSON.parse(data);
    	var args = {
			map: 'europe_en',
            enableZoom: true,
            showTooltip: true,
            backgroundColor: '#fff',
            borderColor: '#fff',
            color: '#dedede',
            onRegionOut: function (element, code, region) {
                document.body.style.cursor = "default";
            },
            onRegionOver: function(element, code, region)
            {
            	// show pointer on euscreen country
                if(mapData[code] != undefined) {
                    document.body.style.cursor = "pointer"; 
                } else {
                    event.preventDefault();
                }
            },
            onRegionClick: function(element, code, region)
            {
            	                // on region click
            	// get region data
                if(mapData[code] != undefined) {

                    // show result section
                    if($('.results-section').css('display') != "block") {
                        $('.results-section').css({'display': 'block'});
                    }
                    
                    // variables
                    var countryData = mapData[code],
                        countryProvider = countryData['providers'],
                        mediaAmount = {'videos': 0, 'audios': 0, 'images': 0, 'texts': 0, 'series': 0},
                        providerLink = "",
                        providerList = "";
                
                    // count
                    for (var item in countryProvider) {
                        
                        // set url
                        //var url = "<li><a href='search-results.html?provider="+item+"'>SEARCH "+item.toUpperCase()+" CONTENT</a></li>";
                        //providerLink += url;
                        providerList += "<span class='provider-list'>"+countryProvider[item].name+ " ("+item.toUpperCase()+") <a href='/search.html?query=*&activeFields=%7B\"provider\"%3A%5B\""+escape(item)+"\"%5D%7D' class='box-link'>SEARCH "+item.toUpperCase()+" CONTENT</a></span>";
                        
                        // add the media
                        mediaAmount['videos'] += countryProvider[item].videos;
                        mediaAmount['audios'] += countryProvider[item].audios;
                        mediaAmount['images'] += countryProvider[item].images;
                        mediaAmount['texts'] += countryProvider[item].texts;
                        mediaAmount['series'] += countryProvider[item].series;
                    }

                    // get general info like country name
                    $('#selected-country').html(mapData[code].country);

                    // set amount of medias
                    $('#selected-videos').html(mediaAmount['videos']);
                    $('#selected-audios').html(mediaAmount['audios']);
                    $('#selected-images').html(mediaAmount['images']);
                    $('#selected-texts').html(mediaAmount['texts']);
                    $('#selected-series').html(mediaAmount['series']);

                    // set providers info
                    //$('#selected-searchlink').html(providerLink);
                    $('#selected-providers').html(providerList);
                } else {

                    // show alert when no provider
                    alert("No EUscreen provider from "+region);
                }
                
                var objectToSend = {
            		'code': code
                }
                eddie.putLou('history', 'setParameter(' + JSON.stringify(objectToSend) + ')');
            }
    	}
    	
    	// window width
        if(params.device == "tablet") {
        	// this is tablet horizontal 
        	args.showTooltip = false;
        } else {

        	args.showTooltip = true; 
        }

    	
    	 // get vmap size
        mapSize.width = $('.maps').width();// + 30; // 30 is the padding
        mapSize.height =  (mapSize.width * 3) / 4 + 15;
        
        console.log("WIDTH: " + mapSize.width); 
        
        // set map size
        $('#vmap').css({
            width: mapSize.width +'px',
            height: mapSize.height +'px'
        });

        // load interactive map
        // using jqvmap (MIT License)
        
        
    	// retrieve providers data (country, the amount of videos, audios etc.) from json file
        // file has to be updated
        $.getJSON( "/eddie/apps/euscreenxlelements/libs/jqvmap/data/euscreen.provider.data.json", function( data ) {
        	
    		$('#vmap').vectorMap(args);
    		
        	
            // set variable
            mapData = data;

            // highlight countries in euscreen
            // for easier search on the map
            var colorsST = {},
                highlightColor = "#c0c1c5";

            // loop
            for (var item in data) {
                colorsST[item] = highlightColor;
            }
                        
            // set
            $('#vmap').vectorMap('set', 'colors', colorsST);
    		$('#jqvmap1_' + params.region).click();
        });
    }
};

Template.prototype = Object.create(Component.prototype);
