package com.essam.employeecrudapi.util;

import java.time.LocalDate;
import java.util.List;


import org.springframework.stereotype.Service;

@Service
public final class AgeCalculatorFromID {
	
	private Integer extractYear(String id) {
		String century = id.substring(0, 1);
		int intCentury = Integer.parseInt(century);
		int YearOfBirth;
		if (intCentury == 2) {
			YearOfBirth = Integer.valueOf(id.substring(1,2)) * 10 +
					Integer.valueOf(id.substring(2,3)) + 1900 ;
		} else  {
			YearOfBirth = Integer.valueOf(id.substring(1,2)) * 10 +
					Integer.valueOf(id.substring(2,3)) + 2000;
		}
		return YearOfBirth;
	}

	private Integer extractMonth(String id) {
		return Integer.valueOf(id.substring(3, 5));
	}
	
	private Integer extractDay(String id) {
		return Integer.valueOf(id.substring(5,7));
	}
	
	public Integer getAge(String id) {
		if(!validateId(id)) {
			throw new IllegalArgumentException("Unsupported National ID"); 
		}
		LocalDate currentDate = LocalDate.now();
		int currentYear = currentDate.getYear();
		int currentMonth = currentDate.getMonthValue();
		int currentDay = currentDate.getDayOfMonth();
		
		
		int age = currentYear - extractYear(id);
		
		if(extractMonth(id) > currentMonth) {
			age--;
		}
		else if(extractMonth(id) == currentMonth) {
			if (extractDay(id) > currentDay) {
				age--;
			}
		}
		
		return age;
	}
	
	
	private boolean validateId(String id) {
		System.out.println(Integer.valueOf(id.substring(3,5)));
		System.out.println(Integer.valueOf(id.substring(5,7)));
		
		int century = Integer.valueOf(id.substring(0,1));
		int year = extractYear(id);
		int month = extractMonth(id);
		int day = extractDay(id);
		List<Integer> month30 = List.of(4, 6, 9, 11);
		if(century != 2 && century != 3)
			return false;
		if(century == 3 && year >= LocalDate.now().getYear()) {
			return false;
		}
		if(month > 12)
			return false;
		if (month < 1)
			return false;
		if(day > 31)
			return false;
		if(day < 1)
			return false;
		
		if(month30.contains(month) && day > 30)
			return false;
		
		if(month == 2 && day > 28 && !isLeapYear(year)) {
			return false;
		}
		
		if(month == 2 && day > 29 && isLeapYear(year)) {
			return false;
		}
			
			
		return true;
	}
	
	private boolean isLeapYear(int year) {
		boolean isLeapYear = false;
		if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }
		return isLeapYear;
	}
}
