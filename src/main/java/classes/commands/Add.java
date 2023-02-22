package classes.commands;

import classes.collection.CollectionManager;
import classes.console.RepeatScanner;
import classes.console.TextColor;
import classes.movie.*;
import exceptions.*;
import interfaces.Command;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static classes.movie.FieldProperty.*;

public class Add implements Command {
    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getInfo() {
        return getName() + "\t\t-\tдобавить новый элемент в коллекцию";
    }

    @Override
    public void execute() {
        CollectionManager collectionManager = new CollectionManager();
        RepeatScanner scanner = new RepeatScanner();
        Movie movie = null;
        boolean wasInput;
        while (movie == null) {
            String name = null;
            while (name == null) {
                try {
                    name = new FieldHandler(
                            scanner.nextLine(TextColor.green("Name: ")),
                            NOT_NULL, NOT_BLANK
                    ).handleString();
                } catch (NullValueException | BlankValueException | BadValueLengthException | NotUniqueException e) {
                    System.out.println(e.toString());
                }
            }
            Coordinates coordinates = null;
            while (coordinates == null) {
                System.out.println(TextColor.green("Coordinates: "));
                Long coordinatesX = null;
                while (coordinatesX == null) {
                    try {
                        coordinatesX = new FieldHandler(
                                scanner.nextLong(TextColor.green("\tX: ")),
                                MAX_VALUE
                        ).handleLong();
                    } catch (NotGreatThanException | NullValueException | GreatThanException e) {
                        System.out.println(e.toString());
                    }
                }
                Integer coordinatesY = null;
                while (coordinatesY == null) {
                    try {
                        coordinatesY = new FieldHandler(
                                scanner.nextInt(TextColor.green("\tY: ")),
                                GREAT_THAN_X
                        ).handleInt();
                    } catch (NotGreatThanException | NullValueException | GreatThanException e) {
                        System.out.println(e.toString());
                    }
                }
                try {
                    coordinates = new Coordinates(coordinatesX, coordinatesY);
                } catch (NotGreatThanException | NullValueException | GreatThanException e) {
                    System.out.println(e.toString());
                }
            }
            wasInput = false;
            Long oscarsCount = null;
            while (!wasInput) {
                try {
                    oscarsCount = new FieldHandler(scanner.nextLong(TextColor.green("Oscars count: ")), GREAT_THAN_ZERO).handleLong();
                    wasInput = true;
                } catch (NullValueException | NotGreatThanException | GreatThanException e) {
                    System.out.println(e.toString());
                }
            }
            wasInput = false;
            Long goldenPalmCount = null;
            while (!wasInput) {
                try {
                    goldenPalmCount = new FieldHandler(
                            scanner.nextLong(TextColor.green("Golden palm count: ")),
                            GREAT_THAN_ZERO
                    ).handleLong();
                    wasInput = true;
                } catch (NullValueException | NotGreatThanException | GreatThanException e) {
                    System.out.println(e.toString());
                }
            }
            wasInput = false;
            Float budget = null;
            while (!wasInput) {
                try {
                    budget = new FieldHandler(
                            scanner.nextFloat(TextColor.green("Budget: ")),
                            GREAT_THAN_ZERO
                    ).handleFloat();
                    wasInput = true;
                } catch (NullValueException | NotGreatThanException | GreatThanException e) {
                    System.out.println(e.toString());
                }
            }
            wasInput = false;
            Integer mpaaRatingId;
            MpaaRating mpaaRating = null;
            while (!wasInput) {
                System.out.println(TextColor.yellow(
                        """
                                Options:
                                1 General Audiences
                                2 Parental Guideness Suggested
                                3 Parents Strongly Cautioned
                                4 Restricted
                                5 No One 17 And Under Admitted"""));
                mpaaRatingId = scanner.nextInt(TextColor.green("MPAA Rating: "));
                if (mpaaRatingId != null)
                    try {
                        mpaaRating = MpaaRating.values()[mpaaRatingId - 1];
                    } catch (IndexOutOfBoundsException e) {
                        new WarningException("Выберите опцию 1-5").printMessage();
                    }
                if (mpaaRatingId == null || mpaaRating != null)
                    wasInput = true;
            }
            Person director = null;
            while (director == null) {
                System.out.println(TextColor.green("Director: "));
                String directorName = null;
                while (directorName == null) {
                    try {
                        directorName = new FieldHandler(
                                scanner.nextLine(TextColor.green("\tName: ")),
                                NOT_NULL, NOT_BLANK
                        ).handleString();
                    } catch (NullValueException | BlankValueException | BadValueLengthException |
                             NotUniqueException e) {
                        System.out.println(e.toString());
                    }
                }
                wasInput = false;
                Date directorBirthday = null;
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                while (!wasInput) {
                    try {
                        directorBirthday = formatter.parse(scanner.nextLine(TextColor.green("Birthday (yyyy-MM-dd): ")));
                        wasInput = true;
                    } catch (ParseException e) {
                        System.out.println(TextColor.yellow("Неверный формат даты"));
                    }
                }
                wasInput = false;
                Double directorHeight = null;
                while (!wasInput) {
                    try {
                        directorHeight = new FieldHandler(scanner.nextDouble(TextColor.green("Height: ")), GREAT_THAN_ZERO).handleDouble();
                        wasInput = true;
                    } catch (NullValueException | NotGreatThanException | GreatThanException e) {
                        System.out.println(e.toString());
                    }
                }
                String directorPassportID = null;
                while (directorPassportID == null) {
                    try {
                        directorPassportID = new FieldHandler(
                                scanner.nextLine(TextColor.green("Passport ID: ")),
                                UNIQUE, LENGTH, NOT_BLANK, NOT_NULL
                        ).handleString();
                    } catch (NullValueException | BlankValueException | BadValueLengthException |
                             NotUniqueException e) {
                        System.out.println(e.toString());
                    }
                }
                Integer eyeColorId;
                Color directorEyeColor = null;
                while (directorEyeColor == null) {
                    System.out.println(TextColor.yellow(
                            """
                                    Options:
                                    1 RED
                                    2 BLACK
                                    3 BLUE
                                    4 BROWN"""));
                    eyeColorId = scanner.nextInt(TextColor.green("Eye color: "));
                    if (eyeColorId != null)
                        try {
                            directorEyeColor = (Color) new FieldHandler(
                                    Color.values()[eyeColorId - 1],
                                    NOT_NULL
                            ).handleObject();
                        } catch (IndexOutOfBoundsException e) {
                            new WarningException("Выберите опцию 1-4").printMessage();
                        } catch (NullValueException e) {
                            System.out.println(e.toString());
                        }
                }
                try {
                    director = new Person(directorName, directorBirthday, directorHeight, directorPassportID, directorEyeColor);
                } catch (BlankValueException | NullValueException | NotGreatThanException | BadValueLengthException |
                         GreatThanException | NotUniqueException e) {
                    System.out.println(e.toString());
                }
            }
            try {
                movie = new Movie(name, coordinates, oscarsCount, goldenPalmCount, budget, mpaaRating, director);
            } catch (BlankValueException | NullValueException | NotGreatThanException | BadValueLengthException |
                     GreatThanException | NotUniqueException e) {
                System.out.println(e.toString());
            }
        }
        collectionManager.addMovie(movie);
    }
}
