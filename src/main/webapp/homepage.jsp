<%-- 
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Green Thrifts - Home</title>
    <link rel="stylesheet" href="styles/mainCss.css">
        <link rel="stylesheet" href="styles/homepage.css">
    
</head>
<body>
    <%@ include file="header.jsp" %>
    
    <main>
        <!-- Hero Section -->
        <section class="hero">
            <div class="hero-content">
                <h1>Shop Pre-Loved Fashion</h1>
                <p>Discover quality secondhand clothing at Green Thrifts.</p>
                <a href="productsPageUser.jsp" class="btn primary">Browse</a>
            </div>
        </section>

        <!-- New Arrivals Section -->
        <section class="products" id="shop">
            <h2>New Arrivals</h2>
            <div class="product-grid">
                <div class="product-card">
                    <img src="https://via.placeholder.com/300x400" alt="Product 1">
                    <h3>Vintage Jacket</h3>
                    <p>$25.00</p>
                </div>
                <!-- Repeat for other cards... -->
            </div>
            <a href="productsPageUser.jsp" class="btn primary">Browse All</a>
        </section>

        <!-- Women's Clothing Section -->
        <section class="products">
            <h2>Women's Clothing</h2>
            <div class="product-grid">
                <div class="product-card">
                    <img src="https://via.placeholder.com/300x400" alt="Product 5">
                    <h3>Floral Blouse</h3>
                    <p>$18.00</p>
                </div>
                <!-- Repeat for other cards... -->
            </div>
            <a href="productsPageUser.jsp?categoryId=2" class="btn primary">Browse All</a>
        </section>

        <!-- Men's Clothing Section -->
        <section class="products">
            <h2>Men's Clothing</h2>
            <div class="product-grid">
                <div class="product-card">
                    <img src="https://via.placeholder.com/300x400" alt="Product 9">
                    <h3>Plaid Shirt</h3>
                    <p>$22.00</p>
                </div>
                <!-- Repeat for other cards... -->
            </div>
            <a href="productsPageUser.jsp?categoryId=1" class="btn primary">Browse All</a>
        </section>

        <!-- Accessories Section -->
        <section class="products">
            <h2>Accessories</h2>
            <div class="product-grid">
                <div class="product-card">
                    <img src="https://via.placeholder.com/300x400" alt="Product 13">
                    <h3>Leather Belt</h3>
                    <p>$15.00</p>
                </div>
                <!-- Repeat for other cards... -->
            </div>
            <a href="productsPageUser.jsp?categoryId=3" class="btn primary">Browse All</a>
        </section>
    </main>
    
    <%@ include file="footer.jsp" %>
</body>
</html>
 --%>
 
 
 
 
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Green Thrifts - Home</title>
    <link rel="stylesheet" href="styles/mainCss.css">
    <link rel="stylesheet" href="styles/homepage.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">
</head>
<body>
    <%@ include file="header.jsp" %>
    
    <main>
        <!-- Hero Section -->
        <section class="hero">
            <div class="hero-content">
                <h1>Discover Pre-Loved Fashion</h1>
                <p>Explore sustainable, high-quality secondhand clothing at Green Thrifts.</p>
                <a href="productsPageUser.jsp" class="btn primary">Shop Now</a>
            </div>
        </section>

        <!-- Categories Section -->
        <section class="categories">
            <h2>Shop by Category</h2>
            <div class="category-grid">
                <div class="category-card">
                    <div class="category-image">
                        <img src="https://via.placeholder.com/300x400" alt="New Arrivals">
                    </div>
                    <h3>New Arrivals</h3>
                    <a href="productsPageUser.jsp" class="btn secondary">Browse</a>
                </div>
                <div class="category-card">
                    <div class="category-image">
                        <img src="https://via.placeholder.com/300x400" alt="Women's Clothing">
                    </div>
                    <h3>Women's Clothing</h3>
                    <a href="productsPageUser.jsp?categoryId=2" class="btn secondary">Browse</a>
                </div>
                <div class="category-card">
                    <div class="category-image">
                        <img src="https://via.placeholder.com/300x400" alt="Men's Clothing">
                    </div>
                    <h3>Men's Clothing</h3>
                    <a href="productsPageUser.jsp?categoryId=1" class="btn secondary">Browse</a>
                </div>
                <div class="category-card">
                    <div class="category-image">
                        <img src="https://via.placeholder.com/300x400" alt="Accessories">
                    </div>
                    <h3>Accessories</h3>
                    <a href="productsPageUser.jsp?categoryId=3" class="btn secondary">Browse</a>
                </div>
            </div>
        </section>
    </main>
    
    <%@ include file="footer.jsp" %>
</body>
</html>