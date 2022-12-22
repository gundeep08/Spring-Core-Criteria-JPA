INSERT INTO `BOOK_PUBLISHING`.`category` (`ID`, `Name`) VALUES ('1', 'Programming');
INSERT INTO `BOOK_PUBLISHING`.`category` (`ID`, `Name`) VALUES ('2', 'System Design');
INSERT INTO `BOOK_PUBLISHING`.`category` (`ID`, `Name`) VALUES ('3', 'Theoritical Foundation');
INSERT INTO `BOOK_PUBLISHING`.`category` (`ID`, `Name`) VALUES ('4', 'Cloud Computing');
INSERT INTO `BOOK_PUBLISHING`.`category` (`ID`, `Name`) VALUES ('5', 'Cloud Communications');
INSERT INTO `BOOK_PUBLISHING`.`category` (`ID`, `Name`) VALUES ('6', 'Devops');

INSERT INTO `BOOK_PUBLISHING`.`book` (`ID`, `CATEGORY_ID`, `ISBN`, `TITLE`, `PRICE`) VALUES ('1', '1', '88888', 'Orielly Java', '29.99');
INSERT INTO `BOOK_PUBLISHING`.`book` (`ID`, `CATEGORY_ID`, `ISBN`, `TITLE`, `PRICE`) VALUES ('2', '2', '77777', 'Models and Designs', '33.49');
INSERT INTO `BOOK_PUBLISHING`.`book` (`ID`, `CATEGORY_ID`, `ISBN`, `TITLE`, `PRICE`) VALUES ('3', '3', '66666', 'Discrete Mathematics', '19.95');
INSERT INTO `BOOK_PUBLISHING`.`book` (`ID`, `CATEGORY_ID`, `ISBN`, `TITLE`, `PRICE`) VALUES ('4', '4', '55555', 'Cloud Infrastructure', '28.50');
INSERT INTO `BOOK_PUBLISHING`.`book` (`ID`, `CATEGORY_ID`, `ISBN`, `TITLE`, `PRICE`) VALUES ('5', '4', '44444', 'Elastic Path', '42.30');

INSERT INTO `BOOK_PUBLISHING`.`author` (`ID`, `FIRST_NAME`, `LAST_NAME`, `DESCRIPTION`) VALUES ('1', 'Kathy', 'Sierra', 'OOPS Based Author');
INSERT INTO `BOOK_PUBLISHING`.`author` (`ID`, `FIRST_NAME`, `LAST_NAME`, `DESCRIPTION`) VALUES ('2', 'Kevin', 'Brian', 'Infrastructure setup based Author');
INSERT INTO `BOOK_PUBLISHING`.`author` (`ID`, `FIRST_NAME`, `LAST_NAME`, `DESCRIPTION`) VALUES ('3', 'Rebecca', 'Nesson', 'Algrothims based Author');
INSERT INTO `BOOK_PUBLISHING`.`author` (`ID`, `FIRST_NAME`, `LAST_NAME`, `DESCRIPTION`) VALUES ('4', 'Yu', 'Brian', 'UI Frontend Author');


INSERT INTO `BOOK_PUBLISHING`.`author_book` (`AUTHOR_ID`, `BOOK_ID`) VALUES ('2', '4');
INSERT INTO `BOOK_PUBLISHING`.`author_book` (`AUTHOR_ID`, `BOOK_ID`) VALUES ('2', '5');
INSERT INTO `BOOK_PUBLISHING`.`author_book` (`AUTHOR_ID`, `BOOK_ID`) VALUES ('1', '1');
INSERT INTO `BOOK_PUBLISHING`.`author_book` (`AUTHOR_ID`, `BOOK_ID`) VALUES ('3', '3');