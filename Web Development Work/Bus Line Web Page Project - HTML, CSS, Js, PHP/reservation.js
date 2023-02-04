function book(){
    var lName = document.getElementById("lName").value;
    
    var fName = document.getElementById("fName").value;
    
                  
    var travelers= document.getElementById("num_travelers").value;
    
    var days= document.getElementById("num_days").value;
    var city = "";
    var cityPrice = 0;
    if(document.getElementById("stLouis").checked){
        city = "St. Louis";
        cityPrice= 40 * travelers;
    } else if(document.getElementById("milwaukee").checked){
        city="Milwaukee";
        cityPrice= 20 * travelers;
    } else {
        city="Detroit";
        cityPrice= 35 * travelers;
    }
    
    var hotel = "";
    var hotelPrice = 0;
    if(document.getElementById("economy").checked){
        hotel="Economy";
        hotelPrice=50 * days;
    } else if(document.getElementById("standard").checked){
        hotel="Standard";
        hotelPrice=70 * days;
    } else {
        hotel="Upscale";
        hotelPrice=120*days;
    }
    
    var am1 = document.getElementById("am1").checked;
    var am2 = document.getElementById("am2").checked;
    
    var amType1 = "";
    var amType2 = "";
    
    var amPrice1 = 0;
    var amPrice2 = 0;
    var none = "";
    if (am1 == true)
            {
                amType1="Wifi ";
                amPrice1 = 10 * travelers;
            }
    if (am2 == true)
            {
                amType2="Fully-Reclining Seats"
                amPrice2 = 20 * travelers;
            }
    if (am1==false && am2==false)
        {
            none="No Amenities"
        }
    var meal = "";
    var mealPrice = 0;
    if(document.getElementById("none").checked){
        meal="None";
        mealPrice=0 * travelers;
    } else if(document.getElementById("snack").checked){
        meal="Snack";
        mealPrice=5 * travelers;
    } else {
        meal="Full Meal";
        mealPrice=10 * travelers;
    }
    
    var specReq = document.getElementById("spec_req").value;
        if (specReq==""){
            specReq="No Special Requests";
        }
    
    var totalCost = cityPrice + hotelPrice + amPrice1 + amPrice2 + mealPrice;
    
    document.getElementById("total").innerHTML= "Hello " + fName +" "+ lName + "! Your estimated trip cost for " + travelers + " person(s) is $" + totalCost + ". You are going to " + city + " for " + days + " days. You are staying at an " + hotel + " hotel. For your bus trip you added: " + amType1 + amType2 + none + ". For your meal you chose: " + meal + ". Special Requests are: '" + specReq + "'";
    event.preventDefault;
    
}
