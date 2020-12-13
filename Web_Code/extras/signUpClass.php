<?php

header('Location: ../userAccount.php');
    $servername = "localhost:3306";
    $username = "root";
    $password = "";
    
    $db = new mysqli($servername, $username, $password, "dance");

    if ($db->connect_error) {
        die("Connection failed: " . $db->connect_error);
      }

    if($_POST["classes"] = "Beginners") {

        $sql = "INSERT INTO classdates(title, date, status) VALUES ('Beginners', '2020-12-15', 1)";
    } elseif($_POST["classes"] = "Intermediate") {
        $sql = "INSERT INTO classdates(title, date, status) VALUES ('Intermediate', '2020-12-15', 1)";
    } else {
        // This takes care of the advanced class
        $sql = "INSERT INTO classdates(title, date, status) VALUES ('Advanced', '2020-12-15', 1)";
    }

    if ($db->query($sql) === TRUE) {
        echo "New record created successfully";
        header('Location: ../userAccount.php');
      } else {
        echo "Error: " . $sql . "<br>" . $db->error;
      }

    header('Location: ../userAccount.php');
      die();
?>