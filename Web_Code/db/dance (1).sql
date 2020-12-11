-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 09, 2020 at 11:46 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dance`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `attend_ID` int(4) NOT NULL,
  `classID` int(4) NOT NULL,
  `Student_ID` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `ID` int(4) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `teacherID` int(4) NOT NULL,
  `skill_ID` int(1) NOT NULL,
  `class_desc` varchar(1000) NOT NULL,
  `maxAttend` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`ID`, `Name`, `teacherID`, `skill_ID`, `class_desc`, `maxAttend`) VALUES
(1, 'first steps', 2, 1, 'boogy time', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `classdates`
--

CREATE TABLE `classdates` (
  `id` int(11) NOT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `date` date NOT NULL,
  `created` datetime NOT NULL,
  `modified` datetime NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '1=Active | 0=Inactive'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `classdates`
--

INSERT INTO `classdates` (`id`, `title`, `date`, `created`, `modified`, `status`) VALUES
(1, 'Internet of Things World Forum', '2020-06-17', '2020-06-04 16:41:40', '2020-06-04 16:41:40', 1),
(2, 'The Future of Money and Technology Summit', '2020-06-27', '2020-06-04 16:41:40', '2020-06-04 16:41:40', 1),
(3, 'Chrome Dev Summit', '2020-06-13', '2020-06-04 16:41:40', '2020-06-04 16:41:40', 1),
(4, 'The Lean Startup Conference', '2020-07-07', '2020-06-04 16:41:40', '2020-06-04 16:41:40', 1),
(5, 'Web Submit for Developers', '2020-07-29', '2020-06-04 16:41:40', '2020-06-04 16:41:40', 1),
(6, 'Digital Codex Submit 2019', '2020-08-11', '2020-06-04 16:41:40', '2020-06-04 16:41:40', 1),
(7, 'Google for Games Developer Summit', '2020-06-17', '2020-06-04 16:41:40', '2020-06-04 16:41:40', 1),
(8, 'Android Dev Summit 2020', '2020-06-27', '2020-06-04 16:41:40', '2020-06-04 16:41:40', 1),
(9, 'Flutter Interact', '2020-06-27', '2020-06-04 16:41:40', '2020-06-04 16:41:40', 1),
(10, 'Software Architecture Conference', '2020-07-18', '2020-06-04 16:41:40', '2020-06-04 16:41:40', 1),
(11, 'Lead Dev London', '2020-06-30', '2020-06-17 16:41:40', '2020-06-17 16:41:40', 1),
(12, 'Cyber Security & Cloud Expo', '2020-06-30', '2020-06-17 16:41:40', '2020-06-17 16:41:40', 1),
(13, 'Blockchain Expo Europe', '2020-07-07', '2020-06-17 16:41:40', '2020-06-17 16:41:40', 1),
(14, 'International Conference on Next Generation Computer and Information Technology', '2020-07-20', '2020-06-17 16:41:40', '2020-06-17 16:41:40', 1),
(15, '5G Expo North America', '2020-07-04', '2020-06-17 16:41:40', '2020-06-17 16:41:40', 1),
(16, '5G Expo North America', '2020-06-13', '2020-06-17 16:41:40', '2020-06-17 16:41:40', 1),
(17, 'IoT Tech Expo North America', '2020-08-21', '2020-06-17 16:41:40', '2020-06-17 16:41:40', 1),
(18, 'CYBER SECURITY & CLOUD EXPO NORTH AMERICA', '2020-08-21', '2020-06-17 16:41:40', '2020-06-17 16:41:40', 1),
(19, '5G Expo Global', '2020-08-31', '2020-06-17 16:41:40', '2020-06-17 16:41:40', 1);

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `pay_ID` int(4) NOT NULL,
  `studentID` int(4) NOT NULL,
  `payment` int(255) DEFAULT NULL,
  `date` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `permissions`
--

CREATE TABLE `permissions` (
  `perm_ID` int(1) NOT NULL,
  `perm_desc` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `permissions`
--

INSERT INTO `permissions` (`perm_ID`, `perm_desc`) VALUES
(1, 'Student'),
(2, 'Teacher'),
(3, 'Manager');

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE `report` (
  `ID` int(4) NOT NULL,
  `Teacher_ID` int(4) NOT NULL,
  `Student_ID` int(4) NOT NULL,
  `description` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `skill`
--

CREATE TABLE `skill` (
  `ID` int(1) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `skill`
--

INSERT INTO `skill` (`ID`, `name`) VALUES
(1, 'Beginner'),
(2, 'Intermediate'),
(3, 'Advanced');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` int(4) NOT NULL,
  `username` varchar(50) NOT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `permissionID` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `username`, `firstname`, `lastname`, `password`, `email`, `permissionID`) VALUES
(1, 'student1', 'billy', 'jean', 'cc03e747a6afbbcbf8be7668acfebee5', 'test@test.com', 1),
(2, 'teacher1', 'heee', 'heee', 'cc03e747a6afbbcbf8be7668acfebee5', 'test@test.com', 2),
(3, 'manager1', 'heee', 'heee', 'cc03e747a6afbbcbf8be7668acfebee5', 'test@test.com', 3);

-- --------------------------------------------------------

--
-- Table structure for table `wages`
--

CREATE TABLE `wages` (
  `ID` int(4) NOT NULL,
  `teacherID` int(4) NOT NULL,
  `wage` int(255) DEFAULT NULL,
  `date` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `wages`
--

INSERT INTO `wages` (`ID`, `teacherID`, `wage`, `date`) VALUES
(1, 2, 420, '0000-00-00'),
(2, 3, 60000, '2020-11-30');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`attend_ID`),
  ADD KEY `classID` (`classID`),
  ADD KEY `Student_ID` (`Student_ID`);

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `teacherID` (`teacherID`),
  ADD KEY `skill_ID` (`skill_ID`);

--
-- Indexes for table `classdates`
--
ALTER TABLE `classdates`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`pay_ID`),
  ADD KEY `studentID` (`studentID`);

--
-- Indexes for table `permissions`
--
ALTER TABLE `permissions`
  ADD PRIMARY KEY (`perm_ID`);

--
-- Indexes for table `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Teacher_ID` (`Teacher_ID`),
  ADD KEY `Student_ID` (`Student_ID`);

--
-- Indexes for table `skill`
--
ALTER TABLE `skill`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `permissionID` (`permissionID`);

--
-- Indexes for table `wages`
--
ALTER TABLE `wages`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `teacherID` (`teacherID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `attend_ID` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `class`
--
ALTER TABLE `class`
  MODIFY `ID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `classdates`
--
ALTER TABLE `classdates`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `pay_ID` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `report`
--
ALTER TABLE `report`
  MODIFY `ID` int(4) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `wages`
--
ALTER TABLE `wages`
  MODIFY `ID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attendance`
--
ALTER TABLE `attendance`
  ADD CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`classID`) REFERENCES `class` (`ID`),
  ADD CONSTRAINT `attendance_ibfk_2` FOREIGN KEY (`Student_ID`) REFERENCES `users` (`ID`);

--
-- Constraints for table `class`
--
ALTER TABLE `class`
  ADD CONSTRAINT `class_ibfk_1` FOREIGN KEY (`teacherID`) REFERENCES `users` (`ID`),
  ADD CONSTRAINT `class_ibfk_2` FOREIGN KEY (`skill_ID`) REFERENCES `skill` (`ID`);

--
-- Constraints for table `payments`
--
ALTER TABLE `payments`
  ADD CONSTRAINT `payments_ibfk_1` FOREIGN KEY (`studentID`) REFERENCES `users` (`ID`);

--
-- Constraints for table `report`
--
ALTER TABLE `report`
  ADD CONSTRAINT `report_ibfk_1` FOREIGN KEY (`Teacher_ID`) REFERENCES `users` (`ID`),
  ADD CONSTRAINT `report_ibfk_2` FOREIGN KEY (`Student_ID`) REFERENCES `users` (`ID`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`permissionID`) REFERENCES `permissions` (`perm_ID`);

--
-- Constraints for table `wages`
--
ALTER TABLE `wages`
  ADD CONSTRAINT `wages_ibfk_1` FOREIGN KEY (`teacherID`) REFERENCES `users` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
