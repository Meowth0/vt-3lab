package com.company.view;

import com.company.model.*;
import com.company.service.SAXGetter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ForSasha {
    Object[] headers = { "Type", "Questions", "AdditionalInfo" };
    private String directory = System.getProperty("user.dir");
    private String pathToSave = directory + "\\bd.txt";
    private SAXGetter saxGetter = new SAXGetter();
    private List<Test> tests = saxGetter.getData();

    public List<TestDto> writeFiles() {
        List<TestDto> testDtoList = new ArrayList<>();

        for (Test test : tests){
            TestDto testDto = new TestDto();

            testDto.setType(test.getClass().getSimpleName());
            testDto.setQuestionsAmount(String.valueOf(test.getQuestions()));
            String value;
            value = test instanceof MathTest ? String.valueOf(((MathTest) test).getLevelOfDifficult()) : "-";
            if (value.equals("-")) {
                value = test instanceof PsychologicalTest ? String.valueOf(((PsychologicalTest) test).getPsychotype()) : "-";
            }
            if (value.equals("-")) {
                value = test instanceof IQTest ? String.valueOf(((IQTest) test).getIQ()) : "-";
            }
            if (value.equals("-")) {
                value = test instanceof LanguageTest ? String.valueOf(((LanguageTest) test).getLanguage()) : "-";
            }
            testDto.setAdditionalInfo(value);

            try(FileWriter writer = new FileWriter(pathToSave, true)){
                writer.write(testDto.toString() + System.getProperty("line.separator"));
            }
            catch (IOException ex){
            }

            testDtoList.add(testDto);
        }

        return testDtoList;
    }


}
