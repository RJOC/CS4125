Index.php - Main page that all users will see

    - index currently bypasses login functionality to allow calndar testing

userAccount.php - The screen for user interaction after user logs in (contains calendar) & Allows user to signup to new class

function.php - Contains the code which shows calendar

payments.php - Contains Past payments and make new payment options

DB updated to contain:

CREATE TABLE `events` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
 `date` date NOT NULL,
 `created` datetime NOT NULL,
 `modified` datetime NOT NULL,
 `status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '1=Active | 0=Inactive',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;