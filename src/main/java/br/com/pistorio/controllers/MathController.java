package br.com.pistorio.controllers;

import br.com.pistorio.exception.UnsupportedMathOperationException;
import br.com.pistorio.math.SimpleMath;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.pistorio.request.converters.NumberConverter.convertToDouble;
import static br.com.pistorio.request.converters.NumberConverter.isNumeric;

@RestController
@RequestMapping("/math")
public class MathController {

    private final SimpleMath math = new SimpleMath();

    //localhost:8080/math/sum/3/3
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return math.sum(convertToDouble(numberOne),convertToDouble(numberTwo));
    }

    //localhost:8080/math/sub/3/3
    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return math.subtraction(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    //localhost:8080/math/mult/3/3
    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return math.multiplication(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    //localhost:8080/math/div/3/3
    @RequestMapping(value = "/div/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
        if(numberTwo.equals("0")) throw new UnsupportedMathOperationException("It is not possible to divide a number by zero");
        return math.division(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    //localhost:8080/math/avg/3/3
    @RequestMapping(value = "/avg/{numberOne}/{numberTwo}")
    public Double average(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return math.average(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    //localhost:8080/math/square/3
    @RequestMapping(value = "/square/{number}")
    public Double squareRoot(
            @PathVariable(value = "number") String number
    ) {
        if(!isNumeric(number)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return math.squareRoot(convertToDouble(number));
    }
}
