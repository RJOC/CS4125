<?php
if (isset($_POST['type']) && isset($_POST['userID'])){
    $connection = mysqli_connect("localhost:3306", "17204097", "mMzaj7h7LJXe", "d17204097");
    $log_ID = preg_replace('#[^0-9]#i', '', $_SESSION['id']);
    $user = preg_replace('#[^0-9]#i', '', $_POST['userID']);
    $sql = "SELECT COUNT(id) FROM users WHERE id='$user'";
    $query = mysqli_query($connection, $sql);
    $exist_count = mysqli_fetch_row($query);
    if($exist_count[0] < 1){
        mysqli_close($connection);
        echo "$user does not exist.";
        exit();
    }
    if (isset($_POST['type'] == "save"){
        $sql = "SELECT COUNT(saveID) FROM saveSystem WHERE userID1='$user' AND accepted='1' OR userID2='$user' AND accepted='1'";
        $query = mysqli_query($connection, $sql);
        $sql = "SELECT COUNT(ID) FROM shaveSystem WHERE userID1='$user' AND userID2='$log_ID'"; 
        $query = mysqli_query($connection, $sql);
        $blockcount1 = mysqli_fetch_row($query);
        $sql = "SELECT COUNT(ID) FROM shaveSystem WHERE userID1='$log_ID' AND userID2='$user'";
        $query = mysqli_query($connection, $sql);
        $blockcount2 = mysqli_fetch_row($query);
        $sql = "SELECT COUNT(saveID) FROM saveSystem WHERE userID1='$log_ID' AND userID2='$user' AND accepted='1'";
        $query = mysqli_query($connection, $sql);
        $row_count1 = mysqli_fetch_row($query);
        $sql = "SELECT COUNT(saveID) FROM saveSystem WHERE userID1='$user' AND userID2='$log_ID' AND accepted='1'";
        $query = mysqli_query($connection, $sql);
        $row_count2 = mysqli_fetch_row($query);
        $sql = "SELECT COUNT(saveID) FROM saveSystem WHERE userID1='$log_ID' AND userID2='$user' AND accepted='0'";
        $query = mysqli_query($connection, $sql);
        $row_count3 = mysqli_fetch_row($query);
        $sql = "SELECT COUNT(saveID) FROM saveSystem WHERE userID1='$user' AND userID2='$log_ID' AND accepted='0'";
        $query = mysqli_query($connection, $sql);
        $row_count4 = mysqli_fetch_row($query);
        if($blockcount1[0] > 0){
            mysqli_close($connection);
            echo "User has you shaved... sorry :(";
            exit();
        } else if($blockcount2[0] > 0){
            mysqli_close($connection);
            echo "You must first unshave user in order to save with them";
            exit();
        } else if ($row_count1[0] > 0 || $row_count2[0] > 0){
            mysqli_close($connection);
            echo "You are already saved with user";
            exit();  
        } else if($row_count3[0] > 0){
            mysqli_close($connection);
            echo "Save request already sent to user";
            exit();
        } else if($row_count4[0] > 0){
            mysqli_close($connection);
            echo "User has sent save request! Please check your save requests";
            exit();
        } else {
            $sql = "INSERT INTO saveSystem(userID1, userID2, datemade) VALUES('$log_ID', '$user', now())";
            $query = mysqli_query($connection, $sql);
            mysqli_close($connection);
            echo "save_request_sent";
            exit();
        }
    } else if ($_POST['type'] == "unsave"){
        $sql = "SELECT COUNT(saveID) FROM saveSystem WHERE userID1='$log_ID' AND userID2='$user' AND accepted='1'";
        $query = mysqli_query($connection, $sql);
        $row_count1 = mysqli_fetch_row($query);
        $sql = "SELECT COUNT(saveID) FROM saveSystem WHERE userID1='$user' AND userID2='$log_ID' AND accepted='1'";
        $query = mysqli_query($connection, $sql);
        $row_count2 = mysqli_fetch_row($query);
        if($row_count1[0] > 0) {
            $sql = "DELETE FROM saveSystem WHERE userID1='$log_ID' AND userID2='$user' AND accepted='1'";
            $query = mysqli_query($connection, $sql);
            mysqli_close($connection);
            echo "unsave_ok";
            exit();
        } else if($row_count2[0] > 0) {
            $sql = "DELETE FROM saveSystem WHERE userID1='$user' AND userID2='$log_ID' AND accepted='1'";
            $query = mysqli_query($connection, $sql);
            mysqli_close($connection);
            echo "unsave_ok";
            exit();
            }  else {
                mysqli_close($connection);
                echo "No save data could be found between your account and user, therefore we cannot unsave you."
                exit();
        }
    }
}
?>