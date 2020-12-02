<?php
require 'controlfunctions.php';


function updatePE($memberID){
    $conn = connectDBMS();
    $stmtUpdatePE = $conn->prepare("UPDATE members SET email = ?, password = SHA2(?, 512) WHERE memberID = ?");
    $stmtUpdatePE->bind_param("ssi", $email,$pword,$memberID);
    $currentEmail = mysqli_real_escape_string($conn ,$_POST['email']);
    $salt = returnSalt($currentEmail);
    if($salt != NULL){
        $currentPassword = mysqli_real_escape_string($conn, $_POST['password']);
        $currentPassword = hash('sha512', $salt.$currentPassword);
        if(validateEmailPassword($currentEmail,$currentPassword)){
            $email = mysqli_real_escape_string($conn ,$_POST['newemail']);
            $pword = mysqli_real_escape_string($conn, $_POST['newpassword']);
            $pword = $salt.$pword;
            if(!($stmtUpdatePE->execute())){
                $msg = "Error has occurred #UPE_FAILURE";
            }else{
                $_SESSION['username'] = $email;
                if(isset($_POST['remember_me'])){
                    $expiration = time()+60*60*6;
                    setcookie('FLAG', 1, $expiration);
                    setcookie('Username', $email, $expiration);
                    setcookie('Password', $pword, $expiration);
                }
                echo '<script type = "text/javascript">window.open("myAccount.php","_self");</script>';
                $msg = "Account updated!";
            }
        }else{
            $msg = "Incorrect email or password!";
        }
    }else{
        $msg = "Incorrect email or password!";
    }
    $msg = stripslashes($msg);
    echo "<br/><h4>$msg</h4>";
    $stmtUpdatePE->close();
    $conn->close();
}

function uploadImage($FLAG,$memberID){ //MUST UNLINK WHEN DELETING ACCOUNT VERY IMPORTANT
    $conn = connectDBMS();
    $target_path = './img/Avatars/';
    deleteImage($FLAG,$memberID);
    $path = $target_path.$memberID."/".$memberID."_".$_FILES["image"]["name"];
        if (!is_dir($target_path.$memberID."/")) {
            mkdir($target_path.$memberID."/");
            chmod(($target_path.$memberID."/"), 0777);
        }
    $paths = checkPhotoPaths($memberID,0,$path);
    $maxsize    = 2097152; // 2MB
    $acceptable = array('image/jpeg','image/jpg','image/gif','image/png');
    $msg = "";
    foreach($paths as &$pathID) { //ARRAY SIZE ISSUE
        if($pathID != NULL){
                $stmtUploadImage = $conn->prepare("UPDATE photos SET photo_path1 = ? WHERE memberID = ?");
        }else{
            $msg = "No file selected! <br>";
        }     
    }
    $stmtUploadImage->bind_param("si", $path,$memberID); // FUCKED
    echo $msg;
    if(($_FILES['image']['size'] >= $maxsize)) {
        echo 'File too large. File must be less than 2 megabytes.';
    }else{
        if($_FILES['image']['size'] == 0){
            echo 'File too large. File must be less than 2 megabytes.';
        }else{
            if((!in_array($_FILES['image']['type'], $acceptable)) && (!empty($_FILES['image']['type']))){
                echo 'Invalid file type. Only JPG, GIF and PNG types are accepted.';
            }else{ 
                if(checkFolderContents($memberID) >= 1){
                    echo "You have reached the upload amount limit, no more uploaded";
                }else{
                    if(move_uploaded_file($_FILES['image']['tmp_name'], $path)){
                        chmod($_FILES['image']['tmp_name'], 0777);
                        chmod($path, 0777);
                        if($stmtUploadImage->execute()){
                            if($FLAG == 0){
                                echo '<script type = "text/javascript">window.open("myAccount.php","_self");</script>';
                            }else{
                                echo '<script type = "text/javascript">window.open("admin.php","_self");</script>';
                            }
                        }else{
                            echo "File upload failed, please try again. #1";
                        } 
                    }else{
                        echo "File upload failed, please try again. #2";
                    } 
                }
            }
        }
    }
    
    $stmtUploadImage->close();
    $conn->close();
}

function deleteImage($FLAG,$memberID){
    $conn = connectDBMS();
    $pathToDelete = checkPhotoPaths($memberID,1,NULL);
        if($pathToDelete[0] != NULL){
            $deleteImage = $conn->prepare("UPDATE photos SET photo_path1 = NULL WHERE memberID = $memberID");
            if($deleteImage->execute()){
                if(unlink($pathToDelete[0])){
                    if($FLAG == 0){
                        echo '<script type = "text/javascript">window.open("myAccount.php","_self");</script>';
                    }elseif($FLAG == 1){
                        echo '<script type = "text/javascript">window.open("admin.php","_self");</script>';
                    }else{
                        //NOTHING
                    }
                }
            }
            $deleteImage->close();
        }
    $conn->close();
}

function returnImage($memberID){
$paths = checkPhotoPaths($memberID,1,NULL);
        if($paths[0] != NULL){
            $value = "<img class=\"card-img-top\" src=\"$paths[0]\"/>";
        }else{
            $value = '<img class="card-img-top" src="http://placehold.it/700x400?text=Image not found"/>';
        }
    echo $value;
}

function checkPhotoPaths($memberID,$flag,$path){
    $msg = '';
    $acceptable = array(NULL);
    $conn = connectDBMS();
    $ID = NULL;
    $checkPhotoPaths = $conn->prepare("SELECT photo_path1 FROM photos WHERE memberID = ?");
    $checkPhotoPaths->bind_param("i", $memberID);

    $checkPhotoPaths->execute();
    $checkPhotoPaths->bind_result($path1);
    $checkPhotoPaths->fetch();
    if($flag == 0){
        if($path1 == NULL){
            $acceptable[0] = 1;
        }
    }else{
        if($path1 != NULL && $path1 != $path){
            $acceptable[0] = $path1;
        }
    }
    $checkPhotoPaths->close();
    return $acceptable;
    $conn->close();
}


function checkFolderContents($memberID){
    $target_path = './img/Avatars/';
    $fileAmount = 0;
    $dir = dir($target_path.$memberID."/");
    while ($file = $dir->Read()){
        if (!(($file == "..") || ($file == "."))){
            if(Is_Dir($target_path.$memberID."/".$file)){
                $fileAmount += countFiles($dir . '/' . $file);
            }else{
            $fileAmount++;
          }
        }
    }
    return $fileAmount;
}
    function updateAccount($FLAG,$memberID){
        $conn = connectDBMS();
        $name = mysqli_real_escape_string($conn ,$_POST['newName']);
        $bio = mysqli_real_escape_string($conn ,$_POST['newBio']);
        $gender = mysqli_real_escape_string($conn ,$_POST['inlineRadioOptions']);
        $seeking = mysqli_real_escape_string($conn ,$_POST['inlineRadioOptions2']);
        $age = mysqli_real_escape_string($conn ,$_POST['newAge']);
        $location = mysqli_real_escape_string($conn ,$_POST['newLocation']);
        
        updateName($memberID,$name);
        updateBio($memberID,$bio);
        updateInterests($memberID,$_POST['interest']);
        updateGender($memberID,$gender);
        updateSeeking($memberID,$seeking);
        updateAge($memberID,$age);
        updateLocation($memberID,$location);
        
        if($FLAG == 0){
            echo '<script type = "text/javascript">window.open("myAccount.php","_self");</script>';
        }else{
            echo '<script type = "text/javascript">window.open("admin.php","_self");</script>';
        }
        
    }
    

    /*
    *
    * 
    */
    function returnBio($memberID){
        $msg = '';
        $conn = connectDBMS();
        $stmtFetchBio = $conn->prepare("SELECT bio FROM description WHERE memberID = ?");
        $stmtFetchBio->bind_param("i", $memberID);

        $stmtFetchBio->execute();
        $stmtFetchBio->bind_result($found);
        $stmtFetchBio->fetch();   
        if($found != NULL){
            $msg = $found;
        } else {
            $msg = "-";
        }
        $stmtFetchBio->close();
        return stripslashes($msg);
        $conn->close();
    }
    function updateBio($memberID,$newBio){
        $conn = connectDBMS();
        $stmtUpdateBio = $conn->prepare("UPDATE description SET bio = ? WHERE memberID = ?");
        $stmtUpdateBio->bind_param("ss", $newBio,$memberID);

        if(!($stmtUpdateBio->execute())){
            echo "Error has occurred #UBIO_FAILURE";
        }
        $stmtUpdateBio->close();
        $conn->close();
    }


    function returnInterests($memberID){
        $conn = connectDBMS();
        $values = array();
        $stmtFetchInterest = $conn->prepare("SELECT interest FROM interests WHERE memberID = ?");
        $stmtFetchInterest->bind_param("i", $memberID);
        if($stmtFetchInterest->execute()){
            $stmtFetchInterest->bind_result($found);
            while($stmtFetchInterest->fetch()){
                array_push($values,$found);
            }
        }
        $stmtFetchInterest->close();
        return $values;
        $conn->close();
    }
    function clearInterests($memberID){
        $conn = connectDBMS();
        $deleteInterests = $conn->prepare("DELETE  FROM interests WHERE memberID = ?");
        $deleteInterests->bind_param("s", $memberID);
        if($deleteInterests->execute()){
            //SUCCESS
        }
        $deleteInterests->close();
        $conn->close();
    }

    function updateInterests($memberID,$interests){
        clearInterests($memberID);
        $conn = connectDBMS();
        $updateInterests = $conn->prepare("INSERT INTO interests (memberID, interest) VALUES(?, ?)");
        $updateInterests->bind_param("is", $memberID,$interest);
        $values = returnInterests($memberID);
        foreach($interests as $interest){
            if(in_array($interest,$values) != TRUE){
                if(!($updateInterests->execute())){
                    echo "Error has occurred #UIN_FAILURE";
                }
            }
        }
        $updateInterests->close();
        $conn->close();
    }

    function returnSeeking($memberID,$num){
        $msg = '';
        $conn = connectDBMS();
        $stmtSeeking = $conn->prepare("SELECT seeking FROM userdata WHERE memberID = ?");
        $stmtSeeking->bind_param("i", $memberID);

        $stmtSeeking->execute();
        $stmtSeeking->bind_result($found);
        $stmtSeeking->fetch();   
        if($found >= 0){
            switch($num){
                case 0:
                    if($found == 0){
                        $msg = "Male";
                    }elseif($found == 1){
                        $msg = "Female";
                    }else{
                        $msg = "Male & Female";
                    }
                    break;
                case 1:
                    if($found == 0){
                        $msg = 0;
                    }elseif($found == 1){
                        $msg = 1;
                    }else{
                        $msg = 2;
                    }
                    break;
                case 2:
                    if($found == 0){
                        $msg = "checked";
                    }else{
                        $msg = FALSE;
                    }
                    break;
                case 3:
                    if($found == 1){
                        $msg = "checked";
                    }else{
                        $msg = FALSE;
                    }
                    break;
                case 4:
                    if($found == 2){
                        $msg = "checked";
                    }else{
                        $msg = FALSE;
                    }
                    break;
                default:
                $msg = "-";
            }
        } else {
            $msg = "-";
        }
        $stmtSeeking->close();
        return stripslashes($msg);
        $conn->close();
    }
    function updateSeeking($memberID,$newSeeking){
        $conn = connectDBMS();
        $updateSeeking = $conn->prepare("UPDATE userdata SET seeking = ? WHERE memberID = ?");
        $updateSeeking->bind_param("si", $newSeeking,$memberID);

        if(!($updateSeeking->execute())){
            echo "Error has occurred #USEK_FAILURE";
        }
        $updateSeeking->close();
        $conn->close();
    }
    function returnSeekingCheckM($memberID){
        return returnSeeking($memberID,2);
    }
    function returnSeekingCheckF($memberID){
        return returnSeeking($memberID,3);
    }
    function returnSeekingCheckMF($memberID){
        return returnSeeking($memberID,4);
    }

    //RETURN NAME
    function returnName($memberID){
        if($memberID == NULL){
            
        }else{
            $msg = '';
            $conn = connectDBMS();
            $stmtFetchName = $conn->prepare("SELECT name FROM members WHERE memberID = ?");
            $stmtFetchName->bind_param("i", $memberID);

            $stmtFetchName->execute();
            $stmtFetchName->bind_result($found);
            $stmtFetchName->fetch();   
            if($found != NULL){
                $msg = $found;
            } else {
                $msg = "-";
            }
            $stmtFetchName->close();
            return stripslashes($msg);
            $conn->close();
        }
    }
    function updateName($memberID,$newName){
        $conn = connectDBMS();
        $updateName = $conn->prepare("UPDATE members SET name = ? WHERE memberID = ?");
        $updateName->bind_param("ss", $newName,$memberID);

        if(!($updateName->execute())){
            echo "Error has occurred #UNAM_FAILURE";
        }
        $updateName->close();
        $conn->close();
    }

    //RETURN AGE
    function returnAge($memberID){
        $msg = '';
        $conn = connectDBMS();
        $stmtFetchAge = $conn->prepare("SELECT age FROM userdata WHERE memberID = ?");
        $stmtFetchAge->bind_param("i", $memberID);

        $stmtFetchAge->execute();
        $stmtFetchAge->bind_result($found);
        $stmtFetchAge->fetch();   
        if($found != NULL){
            $msg = $found;
        } else {
            $msg = "-";
        }
        $stmtFetchAge->close();
        return stripslashes($msg);
        $conn->close();
    }
    function updateAge($memberID,$newAge){
        $conn = connectDBMS();
        $updateAge = $conn->prepare("UPDATE userdata SET age = ? WHERE memberID = ?");
        $updateAge->bind_param("ss", $newAge,$memberID);

        if(!($updateAge->execute())){
            echo "Error has occurred #UAGE_FAILURE";
        }
        $updateAge->close();
        $conn->close();
    }

    

    //RETURN LOCATION
    function returnLocation($memberID){
        $msg = '';
        $conn = connectDBMS();
        $stmtFetchLocation = $conn->prepare("SELECT location FROM userdata WHERE memberID = ?");
        $stmtFetchLocation->bind_param("i", $memberID);

        $stmtFetchLocation->execute();
        $stmtFetchLocation->bind_result($found);
        $stmtFetchLocation->fetch();   
        if($found != NULL){
            $msg = $found;
        } else {
            $msg = "-";
        }
        $stmtFetchLocation->close();
        return stripslashes($msg);
        $conn->close();
    }
    function updateLocation($memberID,$newLocation){
        $conn = connectDBMS();
        $updateLocation = $conn->prepare("UPDATE userdata SET location = ? WHERE memberID = ?");
        $updateLocation->bind_param("ss", $newLocation,$memberID);

        if(!($updateLocation->execute())){
            echo "Error has occurred #ULOC_FAILURE";
        }
        $updateLocation->close();
        $conn->close();
    }


    //RETURN GENDER
    function returnGender($memberID,$num){
        $msg = '';
        $conn = connectDBMS();
        $stmtFetchGender = $conn->prepare("SELECT gender FROM userdata WHERE memberID = ?");
        $stmtFetchGender->bind_param("i", $memberID);

        $stmtFetchGender->execute();
        $stmtFetchGender->bind_result($found);
        $stmtFetchGender->fetch();   
        if($found >= 0){
            switch($num){
                case 0:
                    if($found == 0){
                        $msg = "Male";
                    }else{
                        $msg = "Female";
                    }
                    break;
                case 1:
                    if($found == 0){
                        $msg = 0;
                    }else{
                        $msg = 1;
                    }
                    break;
                case 2:
                    if($found == 0){
                        $msg = "checked";
                    }else{
                        $msg = FALSE;
                    }
                    break;
                case 3:
                    if($found == 1){
                        $msg = "checked";
                    }else{
                        $msg = FALSE;
                    }
                    break;
                default:
                $msg = "-";
            }
        } else {
            $msg = "-";
        }
        $stmtFetchGender->close();
        return stripslashes($msg);
        $conn->close();
    }
    function updateGender($memberID,$newGender){
        $conn = connectDBMS();
        $updateGender = $conn->prepare("UPDATE userdata SET gender = ? WHERE memberID = ?");
        $updateGender->bind_param("ss", $newGender,$memberID);

        if(!($updateGender->execute())){
            echo "Error has occurred #UGEN_FAILURE";
        }
        $updateGender->close();
        $conn->close();
    }

    function returnGenderCheckM($memberID){
        return returnGender($memberID,2);
    }
    function returnGenderCheckF($memberID){
        return returnGender($memberID,3);
    }

    function myAccount($FLAG,$memberID){
        echo '<div class="row">
       <!-- Sidebar Column -->
       <div class="col-lg-4 animated bounceInDown">
           <div class="col-lg-12 portfolio-item">
             <div class="card h-100">
               <a href="#">
               <!--<img class="card-img-top" src="./img/gearoid.jpg" alt="">-->';returnImage($memberID,0); echo '
               </a>
                 <div class="card-body text-dark"> ';
                 returnProfile($memberID);
                 echo '</div> 
             </div>
           </div> 
       </div>
      
       <div class="col-lg-8 list-group download bg-light text-dark mb-5 p-4 animated bounceInUp">';
       if($FLAG == 0){
        echo '<form action="myAccount.php" method="POST" enctype="multipart/form-data" autofocus>';
       }else{
        echo '<form action="admin.php" method="POST" enctype="multipart/form-data" autofocus>';
       }
       echo '<h3><b>Edit Account Details:</b></h3>
         <label><b>Add Profile Photo:</b></label><br>
         <input type="file" accept=".jpg, .jpeg, .png, .gif " name="image"/>
         <br>
         <br>
         <input type="submit" name="uploadImage" value="Upload"/><br>
         <input type="hidden" name="uploadImageID" value="';echo $memberID;echo '"/><br>';
            echo '
       </form>';
        if($FLAG == 0){
        echo '<form action="myAccount.php" method="POST">';
        }else{
        echo '<form action="admin.php" method="POST">';
        }
         echo '<br><label><b>Full Name:</b></label>
         <input type="hidden" name="idval" class="form-control" id="idval" value="'; echo $memberID; echo '" required>
         <input  type="text" name="newName" id="addName" class="form-control" value= "';echo returnName($memberID); echo '" required>
         <br/>
         <label><b>Bio:</b></label>
         <textarea  rows="4" cols="80" class="form-control" name="newBio" id="message"  required data-validation-required-message="Enter your new bio here" maxlength="255" style="resize:none">';echo returnBio($memberID); echo '</textarea><br>
         <br>
         <label><b>Add Interest:</b></label>';echo generateInterests($memberID,0); 
         echo '<br/>
         <label for="inlineRadio1"><b>Gender:</b></label> <!--GENDER -->
         <br>
         <div class="form-check form-check-inline">
           <input class="form-check-input"';echo returnGenderCheckM($memberID); echo ' required type="radio" name="inlineRadioOptions" id="inlineRadio1" value="0">
           <label class="form-check-label"  for="inlineRadio1">Male</label>
         </div>
         <div class="form-check form-check-inline">
             <input class="form-check-input" ';echo returnGenderCheckF($memberID); echo ' type="radio" name="inlineRadioOptions" id="inlineRadio2" value="1">
                         <label class="form-check-label" for="inlineRadio2">Female</label>
         </div>
         <div>
                         <br>
                     </div>
                     <label for=inlineRadio2"><b>Interested in:</b></label>
                     <!--Interested in -->
                     <br>
                     <div class="form-check form-check-inline">
                         <input class="form-check-input"';echo returnSeekingCheckM($memberID); echo ' type="radio" name="inlineRadioOptions2" id="inlineRadio1" value="0">
                         <label class="form-check-label" for="inlineRadio1">Male</label>
                     </div>
                     <div class="form-check form-check-inline">
                         <input class="form-check-input" ';echo returnSeekingCheckF($memberID); echo ' type="radio" name="inlineRadioOptions2" id="inlineRadio2" value="1">
                         <label class="form-check-label" for="inlineRadio2">Female</label>
                     </div>
                     <div class="form-check form-check-inline">
                         <input class="form-check-input"';echo returnSeekingCheckMF($memberID); echo ' type="radio" name="inlineRadioOptions2" id="inlineRadio2" value="2">
                         <label class="form-check-label" for="inlineRadio3">All</label>
                     </div>
       
         <div><br></div>
       
         <div class="form-row">
           <div class="form-group col-md-4">
             <label for="age"><b>Age:</b></label> <!--USERNAME -->
             <input type="number" name="newAge" class="form-control" id="age" min="18" max="120" value="';echo returnAge($memberID); echo '" placeholder="Age" required> 
           </div>
         </div>	
       
         <div class="form-group">
           <label for="exampleFormControlSelect1"><b>County:</b></label> <!--LOCATION -->
           <select class="form-control" name="newLocation" id="exampleFormControlSelect1">
           ';echo generateCounties($memberID,0); echo '
           </select><br>
           <button type="submit" class="btn btn-primary" name="updateAccount">Update Account Details</button>
         </div>
       </form>';
     }


    function returnProfile($memberID){
        if($memberID != NULL){
        $name = returnName($memberID);
            $gender = returnGender($memberID,0);
            $age = returnAge($memberID);
            $location = returnLocation($memberID);
            $seeking = returnSeeking($memberID,0);
            $interests = returnInterests($memberID);
            $bio = returnBio($memberID);

            echo "<h4 class=card-title>
            <a>
            $name
            </a>
            </h4>
            <table>
                <tr>
                    <td>
                        <b>Gender: </b> $gender
                    </td>
                </tr>
                <tr>
                    <td>
                        <b>Age: </b> $age
                    </td>
                </tr>
                <tr>
                    <td>
                        <b>Location: </b>$location
                    </td>
                </tr>
                <tr>
                    <td>
                        <b>Seeking: </b>$seeking
                    </td>
                </tr>
                <tr>
                    <td>
                        <b>Hobbies/Interests: </b>";
                        echo implode(", ",$interests);
                        
                echo "</td>
                </tr>
                <tr>
                    <td>
                    <b>Bio: </b><i>$bio</i>
                    </td>
                </tr>
            </table>";
        }
    }

    function generateCounties($memberID,$flag){
        $outputForm = "";
        if($flag==0){
            $countyArray = array("Antrim","Armagh","Carlow","Cavan","Clare","Cork","Derry","Donegal","Down","Dublin","Fermanagh","Galway","Kerry","Kildare","Kilkenny","Laois","Leitrim","Limerick","Longford","Louth","Mayo","Meath","Monaghan","Offaly","Roscommon","Sligo","Tipperary","Tyrone","Waterford","Westmeath","Wexford","Wicklow");
            $residenceCounty = returnLocation($memberID);
        }else{
            $countyArray = array("","Antrim","Armagh","Carlow","Cavan","Clare","Cork","Derry","Donegal","Down","Dublin","Fermanagh","Galway","Kerry","Kildare","Kilkenny","Laois","Leitrim","Limerick","Longford","Louth","Mayo","Meath","Monaghan","Offaly","Roscommon","Sligo","Tipperary","Tyrone","Waterford","Westmeath","Wexford","Wicklow");
            $residenceCounty = "";
        }
        
        foreach ($countyArray as $county){
            $outputForm .= '<option value="'.$county.'" '.($county==$residenceCounty ? ' selected=\"selected\"' : '').'>'.$county.'</option>';
        }     
        return $outputForm;
    }

    function generateInterests($memberID,$FLAG){
    $interests = array("Soccer","Computers","Football","Movies","Hurling","Glof","Books","Fashion","Food","Tennis","Gym","Horse Riding","Basketball","Singing","Dancing","Cycling","Outdoors","Music","Athletics","Scouts","Martial Arts","Running","Art","Rugby","Pints","Shmokin","Sleeping");
    if($FLAG == 0){
        $selectedInterests = returnInterests($memberID);
    }else{
        $selectedInterests = NULL;
    }
    $length = count($interests);
    echo '<table>';
        for($count=0;$count<$length;$count+=3){
        echo "<tr>";
            echo '<td>'.$interests[$count].' <input style="margin-right:5em;" type="checkbox" '.(in_array($interests[$count],$selectedInterests) ? ' checked' : '').' name="interest[]" value="'.$interests[$count].'"></td>';
            echo '<td>'.$interests[$count+1].' <input style="margin-right:5em;" type="checkbox" '.(in_array($interests[$count+1],$selectedInterests) ? ' checked' : '').' name="interest[]" value="'.$interests[$count+1].'"></td>';
            echo '<td>'.$interests[$count+2].' <input style="margin-right:5em;" type="checkbox" '.(in_array($interests[$count+2],$selectedInterests) ? ' checked' : '').' name="interest[]" value="'.$interests[$count+2].'"></td>';
        echo "</tr>";
        }
    echo '</table>';
    }

                
    //Delete Account
    function deleteAccount($memberID,$FLAG){
        $conn = connectDBMS();
        $stmtDeleteAccountINT = $conn->prepare("DELETE FROM interests WHERE memberID = ?");
        $stmtDeleteAccountMES = $conn->prepare("DELETE FROM messages WHERE senderID = ? OR receiverID = ?");
        deleteImage(3,$memberID);
        $stmtDeleteAccountPHO = $conn->prepare("DELETE FROM photos WHERE memberID = ?");
        $stmtDeleteAccountDES = $conn->prepare("DELETE FROM description WHERE memberID = ?");
        $stmtDeleteAccountNOT = $conn->prepare("DELETE FROM notifications WHERE memberID = ?");
        $stmtDeleteAccountMAT = $conn->prepare("DELETE FROM matches WHERE first_memberID = ? OR second_memberID = ?");
        $stmtDeleteAccountUD = $conn->prepare("DELETE FROM userdata WHERE memberID = ?");
        $stmtDeleteAccountREP = $conn->prepare("DELETE FROM reports WHERE userReportedID = ? OR userClaimID = ?");
        $stmtDeleteAccountMEM = $conn->prepare("DELETE FROM members WHERE memberID = ?");
        $stmtDeleteAccountINT->bind_param("i", $memberID);
        $stmtDeleteAccountMES->bind_param("ii",$memberID, $memberID);
        $stmtDeleteAccountPHO->bind_param("i", $memberID);
        $stmtDeleteAccountDES->bind_param("i", $memberID);
        $stmtDeleteAccountNOT->bind_param("i", $memberID);
        $stmtDeleteAccountMAT->bind_param("ii",$memberID, $memberID);
        $stmtDeleteAccountUD->bind_param("i", $memberID);
        $stmtDeleteAccountREP->bind_param("ii", $memberID,$memberID);
        $stmtDeleteAccountMEM->bind_param("i", $memberID);
        $stmtDeleteAccountINT->execute();
        $stmtDeleteAccountMES->execute();
        $stmtDeleteAccountPHO->execute();
        $stmtDeleteAccountDES->execute();
        $stmtDeleteAccountNOT->execute();
        $stmtDeleteAccountMAT->execute();
        $stmtDeleteAccountUD->execute();
        $stmtDeleteAccountREP->execute();
        $stmtDeleteAccountMEM->execute();
        $stmtDeleteAccountINT->close();
        $stmtDeleteAccountMES->close();
        $stmtDeleteAccountPHO->close();
        $stmtDeleteAccountDES->close();
        $stmtDeleteAccountNOT->close();
        $stmtDeleteAccountMAT->close();
        $stmtDeleteAccountUD->close();
        $stmtDeleteAccountREP->close();
        $stmtDeleteAccountMEM->close();
        $fileName = './img/Avatars/'.$memberID;
        unlink($fileName);
        if($FLAG == 0){
            echo '<script type = "text/javascript">window.open("logout.php","_self");</script>';
        }
        $conn->close();
    }

    function accountLoggedIn(){
        if(loggedIn() == FALSE){
            echo '<script type = "text/javascript">window.open("login.php","_self");</script>';
        }
    }
?>