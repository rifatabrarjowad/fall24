<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homework 10</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Homework 10</h1>
    <form method="GET" action="index.php">
        <input type="text" name="value1" class="<?php echo $value1Class; ?>" value="<?php echo isset($_GET['value1']) ? htmlspecialchars($_GET['value1']) : ''; ?>">
        
        <select name="operation">
            <option value="multiply" <?= (isset($_GET['operation']) && $_GET['operation'] == 'multiply') ? 'selected' : '' ?>>×</option>
            <option value="divide" <?= (isset($_GET['operation']) && $_GET['operation'] == 'divide') ? 'selected' : '' ?>>÷</option>
            <option value="add" <?= (isset($_GET['operation']) && $_GET['operation'] == 'add') ? 'selected' : '' ?>>+</option>
            <option value="subtract" <?= (isset($_GET['operation']) && $_GET['operation'] == 'subtract') ? 'selected' : '' ?>>-</option>
        </select>
        
        <input type="text" name="value2" class="<?php echo $value2Class; ?>" value="<?php echo isset($_GET['value2']) ? htmlspecialchars($_GET['value2']) : ''; ?>">
        
        <button type="submit">Calculate</button>
    </form>
    
    <p>Result: 
    <?php
    $value1Class = '';
    $value2Class = '';
    $result = null; 
    $history = [];

    include 'data.php';

    if (isset($_GET['value1'], $_GET['value2'], $_GET['operation'])) {
        $value1 = $_GET['value1'];
        $value2 = $_GET['value2'];
        $operation = $_GET['operation'];

        if (!is_numeric($value1)) {
            $value1Class = 'error';
        }
        if (!is_numeric($value2)) {
            $value2Class = 'error';
        }

        if (is_numeric($value1) && is_numeric($value2)) {
            switch ($operation) {
                case 'multiply':
                    $result = $value1 * $value2;
                    $operation = "*";
                    break;
                case 'divide':
                    $result = $value2 != 0 ? $value1 / $value2 : "ERROR (Division by Zero)";
                    $operation = "/";
                    break;
                case 'add':
                    $result = $value1 + $value2;
                    $operation = "+";
                    break;
                case 'subtract':
                    $result = $value1 - $value2;
                    $operation = "-";
                    break;
            }

            if (is_numeric($result)) {
                $history[] = [
                    'input1' => $value1,
                    'operation' => $operation,
                    'input2' => $value2,
                    'output' => $result,
                ];
            }
        } else {
            echo "ERROR";
        }
    }


    if ($result !== null) {
        echo htmlspecialchars($result);
    }
    ?>
    </p>

    <h2>Calculation History</h2>
    <table border="1">
        <tr>
            <th>Input1</th><th>Operation</th><th>Input2</th><th>Output</th>
        </tr>
        <?php
        
        foreach ($history as $entry): ?>
            <tr>
                <td><?= htmlspecialchars($entry['input1']) ?></td>
                <td><?= htmlspecialchars($entry['operation']) ?></td>
                <td><?= htmlspecialchars($entry['input2']) ?></td>
                <td><?= htmlspecialchars($entry['output']) ?></td>
            </tr>
        <?php endforeach; ?>
    </table>

</body>
<script>
document.addEventListener('DOMContentLoaded', function() {
    const value1 = document.querySelector('input[name="value1"]');
    const value2 = document.querySelector('input[name="value2"]');
    const button = document.querySelector('button[type="submit"]');

    function validate() {
        const isNumber = (value) => !isNaN(parseFloat(value)) && isFinite(value);

        if (isNumber(value1.value)) {
            value1.classList.remove('error');
        } else {
            value1.classList.add('error');
        }

        if (isNumber(value2.value)) {
            value2.classList.remove('error');
        } else {
            value2.classList.add('error');
        }

        
        button.disabled = !(isNumber(value1.value) && isNumber(value2.value));
    }

    value1.addEventListener('input', validate);
    value2.addEventListener('input', validate);
    validate(); 
});
</script>
</html>
