
chartData= decodeHtml(chartData);
let jsonChart= JSON.parse(chartData);
let numericData=[]
let textData=[]

for(let i=0 ; i<jsonChart.length; i++ ){
    numericData[i]=jsonChart[i].projectStatus;
    textData[i]=jsonChart[i].label;

}

 new Chart(document.getElementById('myPieChart'), {
 type: 'pie',
     data: {
          labels: textData,
          datasets: [{
            label: '# of Votes',
            data: numericData,
            borderWidth: 1,

          }]
        },
     options: {
     display:true,
     text:"Project Status"
     }
  });

  function decodeHtml(html){
    let txt= document.createElement("textarea");
    txt.innerHTML= html;
    return txt.value;
  }
function validateForm() {
  let fname = document.forms["newEmployee"]["firstName"].value;
  let lname = document.forms["newEmployee"]["lastName"].value;
  let email = document.forms["newEmployee"]["email"].value;
  if (fname == "" || lname=="" || email=="") {
    alert("Name must be filled out");
    return false;
  }
}

