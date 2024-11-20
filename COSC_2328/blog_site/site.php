<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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