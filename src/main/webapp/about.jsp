<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>About GreenThrift</title>
    <link rel="stylesheet" href="styles/mainCss.css">
    <link rel="stylesheet" href="styles/about.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
</head>
<body>
    <%@ include file="header.jsp" %>

    <div class="about-container">
    <h1>About GreenThrift</h1> 
    <p class="intro">
    GreenThrift is a sustainable thrift store promoting eco-friendly shopping by offering second-hand products.
    Our mission is to reduce waste and encourage recycling through a user-friendly platform.
    We believe that small choices—like buying second-hand—can lead to big environmental impacts.
    </p>

        <a href="homepage.jsp" class="back-link"><i class="fas fa-arrow-left"></i> Back to Home</a>

        <div class="team-section">
    <h2>Meet Our Team</h2>

    <div class="team-row">
    <div class="team-member">
        <img src="images/male-avatar.png" alt="Krish">
        <h3>Krish</h3>
        <p>Krish brings his full-stack web development skills and passion for clean UI design to GreenThrift.</p>
    </div>
    <div class="team-member">
        <img src="images/female-avatar.png" alt="Sabina">
        <h3>Sabina</h3>
        <p>Sabina ensures our platform is intuitive and user-friendly, focusing on front-end architecture.</p>
    </div>
    <div class="team-member">
        <img src="images/female-avatar.png" alt="Sima">
        <h3>Sima</h3>
        <p>Sima leads our sustainability research and content, spreading awareness about eco-conscious living.</p>
    </div>
</div>
    <div class="team-row center-row">
    <div class="team-member">
        <img src="images/male-avatar.png" alt="Loveson">
        <h3>Loveson</h3>
        <p>Loveson handles backend services and system optimization, ensuring smooth platform performance.</p>
    </div>
    <div class="team-member">
        <img src="images/male-avatar.png" alt="Yojan">
        <h3>Yojan</h3>
        <p>Yojan leads deployment and DevOps, keeping GreenThrift scalable, reliable, and secure.</p>
    </div>
</div>

</div>


    </div>

    <%@ include file="footer.jsp" %>
</body>
</html>
