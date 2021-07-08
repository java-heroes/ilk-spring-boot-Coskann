package com.gokhantamkoc.ilkspringbootuygulamamodevi.service;

import com.gokhantamkoc.ilkspringbootuygulamamodevi.dto.ShapeDto;
import com.gokhantamkoc.ilkspringbootuygulamamodevi.exceptions.ShapeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ShapeService {
    ArrayList<ShapeDto> shapes = new ArrayList<>();

    public ArrayList<ShapeDto> listShape() {
        return shapes;
    }

    public ShapeDto getShape(Integer id) {
        for (ShapeDto shape : shapes) {
            if (shape.getId() == id) {
                return shape;
            }
        }
        throw new ShapeNotFoundException(id);
    }

    public ShapeDto addShape(ShapeDto shapeDto) {
        shapes.add(shapeDto);
        shapeDto.setId(shapes.size() - 1);
        return shapeDto;
    }

    public ShapeDto updateShape(ShapeDto shapeDto) {
        int j = 0;
        for (ShapeDto shape : shapes) {
            if (shape.getId() == shapeDto.getId()) {
                shapes.get(j).setX(shapeDto.getX());
                shapes.get(j).setY(shapeDto.getY());
                return shapes.get(j);
            }
            j++;
        }
        throw new ShapeNotFoundException(shapeDto.getId());
    }

    public ShapeDto deleteShape(ShapeDto shapeDto) {
        int j = 0;
        for (ShapeDto shape : shapes) {
            if (shape.getId() == shapeDto.getId()) {
                return shapes.remove(j);
            }
            j++;
        }
        throw new ShapeNotFoundException(shapeDto.getId());
    }

}