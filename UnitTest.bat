set CLASSPATH=lib\junit-4.10.jar;.;src;

javac -d . test\com\sensis\faketextcreation\generator\GenerateSentenceTest.java test\com\sensis\faketextcreation\generator\GenerateFollowUpsTest.java test\com\sensis\faketextcreation\filtersource\FileArgsStringTest.java test\com\sensis\faketextcreation\filtersource\FileArgsStringTest.java


java org.junit.runner.JUnitCore com.sensis.faketextcreation.generator.GenerateSentenceTest com.sensis.faketextcreation.generator.GenerateFollowUpsTest com.sensis.faketextcreation.filtersource.FileArgsStringTest com.sensis.faketextcreation.filtersource.FileArgsStringTest

