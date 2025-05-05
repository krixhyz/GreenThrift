<h2>Add New Product</h2>
<form action="adminProduct" method="post">
    <input type="hidden" name="action" value="add" />
    Name: <input type="text" name="name" required /><br/>
    Description: <input type="text" name="description" required /><br/>
    Price: <input type="number" step="0.01" name="price" required /><br/>
    Stock: <input type="number" name="stock" required /><br/>
    Category ID: <input type="number" name="categoryId" required /><br/>
    Admin ID: <input type="number" name="adminId" required /><br/>
    <button type="submit">Add Product</button>
</form>
