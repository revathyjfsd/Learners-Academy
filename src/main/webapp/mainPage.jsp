<!DOCTYPE html>
<html lang="en">
<head>
<title>CSS Template</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="style.css">
</head>
<script type = "text/javascript" >
function preventBack() { window.history.forward(); }
setTimeout("preventBack()", 0);
window.onunload = function () { null };
</script>
<body>

<header>
  <h2>Learner's Academy 
  </h2>
</header>

<section>
  <nav>
    <ul>
    	<br>
      	<li><a href="./studentDetails.jsp" target="iframe_learners"><b>Student List</b></a></li>
      	<br>
      	<li><a href="./teacherDetails.jsp" target="iframe_learners"><b>Teacher List</b></a></li>
      	<br>
      	<li><a href="./subjectDetails.jsp" target="iframe_learners"><b>Subject List</b></a></li>
      	<br>
      	<li><a href="./classDetails.jsp" target="iframe_learners"><b>Class List</b></a></li>
      	<br>
      	<li><a href="./assignClassSubjects.jsp" target="iframe_learners" ><b>Allocate</b></a></li>
		<br>
      	<li><a href="./classReport.jsp" target="iframe_learners"><b>Class report</b></a></li>
      	<br>
		<li><a href="./logout.jsp" onclick="return confirm('Are you sure. \nYou want to logout?')"><b>Logout</b></a></li>
    </ul>
  </nav>
  
  <article>
  
  <iframe name="iframe_learners" src="content.jsp" height="550px" width="100%" title="Learners_portal">
    </iframe>
  </article>
</section>
<footer>
 <p><h4>Learner's Academy Application</h4>
  <p>copyright &copy 2022 learnerAcademy.com</p>
</footer>

</body>
</html>

