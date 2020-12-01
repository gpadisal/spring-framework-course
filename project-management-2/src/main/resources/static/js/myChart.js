var chartDataStr = decodeHtml(chartData);
var jsonArray = JSON.parse(chartDataStr);

var jsonLength = jsonArray.length;

var numericData = [];
var labelData = [];

for( var i=0; i< jsonLength; i++){
	numericData[i] = jsonArray[i].value;
	labelData[i] = jsonArray[i].label;	
}

// For a pie chart
new Chart(document.getElementById('myPieChart'), {
    type: 'pie',
    // The data for our dataset
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#808080", "#FF0000", "#800000"],
            borderColor: '#FFFFFF',
            data: numericData
        }]
    },

    // Configuration options go here
    options: {
    	title:{
    		display: true,
    		text : 'Project Statuses'
    	}
    }

});

//Convert encoded json notation to string format
function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}