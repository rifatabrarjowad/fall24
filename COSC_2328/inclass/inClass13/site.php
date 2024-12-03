
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        form {
            margin-bottom: 20px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            max-width: 500px;
        }
        form input, form textarea {
            width: 100%;
            margin: 10px 0;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        form button {
            padding: 10px 15px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        form button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<?php
echo "Hello World";
?>

<?php
define('DBHOST', 'localhost');
define('DBNAME', 'blog_site');
define('DBUSER', 'root');
define('DBPASS', '');
define('DBCONNSTRING', "mysql:host=" . DBHOST . ";dbname=" . DBNAME);
?>

<?php
try {
    $pdo = new PDO(DBCONNSTRING, DBUSER, DBPASS);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    echo "Connected successfully\n";
} catch (PDOException $e) {
    echo "Connection failed: " . $e->getMessage();
}

?>
<!-- Part 2 -->
<form method="POST" action="site.php">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required>

    <label for="body">Body:</label>
    <textarea id="body" name="body" rows="5" required></textarea>

    <button type="submit">Create Post</button>
</form>

<?php 
if ($_SERVER['REQUEST_METHOD'] === 'POST' && !empty($_POST['title']) && !empty($_POST['body'])) {
    $title = $_POST['title'];
    $body = $_POST['body'];

    $stmt = $pdo->prepare("INSERT INTO posts (title, body) VALUES (:title, :body)");
    $stmt->bindValue(':title', $title, PDO::PARAM_STR);
    $stmt->bindValue(':body', $body, PDO::PARAM_STR);
    $stmt->execute();
}
?>
<?php
$sql = "SELECT * FROM posts";
$result = $pdo->query($sql);

while ($row = $result->fetch()) {
    echo $row['id'] . " - " . $row['title'] . " - " . $row['body'] . "\n";
}

?>

<?php
echo "<table border='1'>";
echo "<tr><th>ID</th><th>Title</th><th>Body</th></tr>";

$sql = "SELECT * FROM posts";
$result = $pdo->query($sql);

while ($row = $result->fetch()) {
    echo "<tr>";
    echo "<td>" . $row['id'] . "</td>";
    echo "<td>" . $row['title'] . "</td>";
    echo "<td>" . $row['body'] . "</td>";
    echo "</tr>";
}

echo "</table>";
?>

</body>
</html>