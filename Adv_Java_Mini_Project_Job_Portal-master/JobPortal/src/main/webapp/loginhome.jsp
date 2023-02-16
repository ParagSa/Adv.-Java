<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://code.jquery.com/jquery-3.6.0.slim.min.js"></script>
    <script
      src="https://kit.fontawesome.com/yourcode.js"
      crossorigin="anonymous"
    ></script>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://unicons.iconscout.com/release/v4.0.0/css/line.css"
    />
    <link rel="stylesheet" href="css/style.css" />
    <script>

function check(){
	let url ="login.html";

	let uname = getCookie('uname');
	let upass = getCookie('upass');
	if(uname!="" && upass!=""){
		url="index.html"
	}
}

function getCookie(cname) {
	  let name = cname + "=";
	  let decodedCookie = decodeURIComponent(document.cookie);
	  
	  console.log(decodedCookie , typeof decodedCookie); //uname=Kiran; upass=Kiran string
	  
	  let ca = decodedCookie.split(';');

	  console.log(ca, typeof ca) // 
	  /*
	  Array [ "uname=Kiran", " upass=Kiran" ]
​
		0: "uname=Kiran"
​
		1: " upass=Kiran"
​
		length: 2
	  */

	  for(let i = 0; i <ca.length; i++) {
		  console.log(ca[i]);
		  let c = ca[i];
	    while (c.charAt(0) == ' ') {
	      c = c.substring(1);
	    }
	    if (c.indexOf(name) == 0) {
	      return c.substring(name.length, c.length);
	    }
	  }
	  return "";
	}
</script>
    
    <title>
      Job Portal - You are one step away from getting a job for a day!
    </title>
  </head>
  <body>
    <!-- ==================== header ================== -->

    <header id="header">
      <div class="container search_job_header">
        <div class="row">
          <div class="col job_search">
            <h6 class="lead">
              We have 850,000 great job offers you deserve!
            </h6>
            <h1 class="display1 mt-5">
              You can Search Job<br />of your choice Below
            </h1>
          </div>
        </div>
        <div class="row">
          <div class="col-md-4">
            <label for="" class="form-label"></label>
            <input class="form-control" type="text" placeholder="Job Title" />
          </div>
          <div class="col-md-4">
            <label for="" class="form-label"></label>
            <input class="form-control" type="date" />
          </div>
          <div class="col-md-4">
            <label for="" class="form-label"></label>
            <input class="form-control" type="text" placeholder="location" />
          </div>
        </div>
        <div class="row">
          <div class="col">
            <div class="col-1 m-auto">
              <a href="#" class="btn btn-success mt-5">Search</a>
            </div>
          </div>
        </div>
      </div>
    </header>
    <!-- ==================== main ================== -->
    <div class="main">
      <!-- ==================== Features ================== -->
      <div class="container features">
        <div class="row">
          <div class="col-md-3 col-sm-6">
            <div class="feature">
              <i class="fa fa-search" aria-hidden="true"></i>
              <h5>Search Millions of Jobs</h5>
              <p>Jobs are available from every single field 24*7</p>
            </div>
          </div>
          <div class="col-md-3 col-sm-6">
            <div class="feature">
              <i class="fa fa-users" aria-hidden="true"></i>
              <h5>Easy To Manage Jobs</h5>
              <p>
                We have made it so simple that you can find out the job of your
                skill so easily
              </p>
            </div>
          </div>
          <div class="col-md-3 col-sm-6">
            <div class="feature">
              <i class="fa fa-briefcase" aria-hidden="true"></i>
              <h5>Top Careers</h5>
              <p>
                Build connections and grab the job opportunities every single
                day
              </p>
            </div>
          </div>
          <div class="col-md-3 col-sm-6">
            <div class="feature">
              <i class="fa fa-user" aria-hidden="true"></i>
              <h5>Search Expert Candidates</h5>
              <p>
                find the helpers based on thier ratings which is real time
                rating provide to them
              </p>
            </div>
          </div>
        </div>
      </div>

      <!-- ==================== Popular Categories ================== -->
      <div id="category">
        <div class="container">
          <div class="row">
            <div class="col heading">
              <h3 class="category_heading m-auto">Popular Categories</h3>
            </div>
          </div>
          <div class="row">
            <div class="col-md-3 col-sm-6">
              <img src="img/plumber.jpg" width="100%" alt="" />
              <h5>Plumber</h5>
            </div>
            <div class="col-md-3 col-sm-6">
              <img src="img/driver.jpg" width="100%" alt="" />
              <h5>Driver</h5>
            </div>
            <div class="col-md-3 col-sm-6">
              <img src="img/mason.jpg" width="100%" alt="" />
              <h5>Mason</h5>
            </div>
            <div class="col-md-3 col-sm-6">
              <img src="img/cleaner.jpg" width="100%" alt="" />
              <h5>cleaner</h5>
            </div>
            <div class="col-md-3 col-sm-6">
              <img src="img/pet walker.jpg" width="100%" alt="" />
              <h5>pet walker</h5>
            </div>
            <div class="col-md-3 col-sm-6">
              <img src="img/photgrapher.jpeg" width="100%" alt="" />
              <h5>photgrapher</h5>
            </div>
            <div class="col-md-3 col-sm-6">
              <img src="img/mechanic.jpeg" width="100%" alt="" />
              <h5>Mechanic</h5>
            </div>
            <div class="col-md-3 col-sm-6">
              <img src="img/maid.jpg" width="100%" alt="" />
              <h5>maid</h5>
            </div>
          </div>
        </div>
      </div>
      <!-- ========== Blogs ============== -->
      <div id="blogs">
        <div class="container">
          <div class="row">
            <div class="col heading">
              <h3>Recent Blog</h3>
            </div>
          </div>
          <div class="row">
            <div class="col-md-3 blog_cols">
              <div class="img">
                <img src="img/blog/img1webp.webp" alt="" width="100%">
              </div>
                <p class="lead">JUNE 16, 2022 </p>
                <h5 class="news_heading"><a href="">e-Shram generates hope for unorganised sector workers, but hardships won't disappear overnight</a></h5>
                <p class="lead">
                  “I faced salary cuts, then worked without pay for a few months, and was finally forced to resign. I could not bear the costs of my daughter’s education and family's expenses,” says Atanu Sarkar, a driver at a private firm who quit his job in June.
                </p>              
             
            </div>
            <div class="col-md-3 blog_cols">
              <div class="img">
                <img src="img/blog/img2.webp" alt="" width="100%">
              </div>
                <p class="lead">JUNE 16, 2022 </p>
                <h5 class="news_heading"><a href="">Centre rolls out new survey to map job creation in the informal sector</a></h5>
                <p class="lead">
                  NEW DELHI : The Union government on Sunday rolled out a nationwide survey to map employment generation in the unorganized sector and establishments deploying less than 10 workers.
                </p>              
             
            </div>
            <div class="col-md-3 blog_cols">
              <div class="img">
                <img src="img/blog/im3.webp" alt="" width="100%">
              </div>
                <p class="lead">JUNE 16, 2022 </p>
                <h5 class="news_heading"><a href="">Govt committed to welfare of unorganised workforce says PM Narendra Modi</a></h5>
                <p class="lead">
                  Prime Minister Narendra Modi on Saturday said that the Government of India was committed to the welfare of unorganised workforce.
  
  Prime Minister Modi further said that the participation of the unorganised labour was very important in the development of the country.
  
  In a tweet, the Prime Minister said, "The participation of our unorganized labour brothers and sisters is very important in the development of the country. Our government is always striving to make the lives of crores of such workers easier. While these schemes have ensured their social security, many more steps were taken to help during the pandemic as well."</p>              
             
            </div>
            <div class="col-md-3 blog_cols">
              <div class="img">
                <img src="img/blog/img4.jpg" alt="" width="100%">
              </div>
                <p class="lead">JUNE 16, 2022 </p>
                <h5 class="news_heading"><a href="">Modi govt on employment: Agnipath scheme, 10 lakh jobs in 18 months | All you need to know about big jobs push</a></h5>
                <p class="lead">
                  Various departments and ministries were asked to prepare the details of vacancies following PM Modi's direction to this effect and the decision to recruit 10 lakh people was taken following an overall review. The government also unveiled a radical Agnipath scheme, short-term employment for youngsters as soldiers in the armed forces, under which over 46,000 people are likely to be inducted in the first go.
                </p>              
             
            </div>
          </div>
        </div>
      </div>

      <!-- ==================== testimonial ================== -->
    </div>

    <!-- ========== nav_menu ============== -->
    <div class="nav_menu navigation" id="nav-menu">
      <div class="row">
        <div class="col-md-3 justify-content-space-between">
             <div class="row title-bar">
               <div class="col-9">
                 <h2><a class="title" href="index.html">Job for a day!</a></h2>
               </div>
               <div class="col-3 d-sm-none" id="menu-icon">
                 <i class="fa fa-list" id="menu_toggle"></i>
               </div>
             </div>
           </div>
           <div class="col-md-9">
             <nav class="row">
               <div class="col-sm-7">
                 <ul class="nav_bar">
                   <li><a href="index.html">Home</a></li>
                   <li><a href="about.html">About</a></li>
                   <li><a href="blog.html">Blog</a></li>
                   <li><a href="contact.html">Contact</a></li>
                   <li><a href="login.html">Login</a></li>
                 </ul>
               </div>
               <div class="col-sm-5">
                 <a href="postjob.html" class="btn bg-primary text-light"
                   >Post a Job</a
                 >
                 <a href="index.html" class="btn bg-success text-light">Search a Job</a>
               </div>
             </nav>
           </div>
         </div>
       </div>
    <!-- ============= Footer ============== -->

    <footer id="footer">
      <div class="container footer">
        <div class="row">
          <div class="col-md-3 col-sm-6">
            <h3>About</h3>
            <p>
              We aim to provide job for a day for every individual who is
              looking out for an Job!
            </p>
            <ul>
              <li><a href="#facebook">facebook</a></li>
              <li><a href="#Twitter">Twitter</a></li>
              <li><a href="#Instagram">Instagram</a></li>
              <li><a href="#Yotube">YouTube</a></li>
            </ul>
          </div>
          <div class="col-md-3 col-sm-6">
            <h5>Employers</h5>
            <ul>
              <li><a href="">Register</a></li>
              <li><a href="">Post a Job</a></li>
              <li><a href="">Advance Skill Search</a></li>
              <li><a href="">Recruiting Service</a></li>
              <li><a href="">Blog</a></li>
            </ul>
          </div>
          <div class="col-md-3 col-sm-6">
            <h5>Workers</h5>
            <ul>
              <li><a href="">Register</a></li>
              <li><a href="">Post Your Skills</a></li>
              <li><a href="">Job Search</a></li>
              <li><a href="">Emploer Search</a></li>
            </ul>
          </div>
          <div class="col-md-3 col-sm-6">
            <h5>Have a question?</h5>
            <ul>
              <li>
                <a href=""> 203, Ramsan Road, BKC Complex, Mumbai, India</a>
              </li>
              <li><a href="">+91 02292 3929 210</a></li>
              <li><a href="">info@jobportal.com</a></li>
            </ul>
          </div>
        </div>
      </div>
    </footer>
    <script src="js/main.js"></script>
  </body>
</html>
