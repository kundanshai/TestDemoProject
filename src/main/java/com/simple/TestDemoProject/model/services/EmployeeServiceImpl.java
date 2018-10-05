package com.simple.TestDemoProject.model.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.TestDemoProject.model.Address;
import com.simple.TestDemoProject.model.EmployeeInfo;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EntityManager entityManager;

	@Override
	public void empSave(EmployeeInfo empInfo) {

	}

	@Override
	public List<EmployeeInfo> getEmployee(EmployeeInfo empInfo) {
		List<EmployeeInfo> empList = null;
		try {
			Query query = entityManager.createQuery("from EmployeeInfo where email_Id=:email_Id")
					.setParameter("email_Id", empInfo.getEmailId());
			empList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}

	@Override
	public List<EmployeeInfo> searchEmpInfo(EmployeeInfo empInfo) {
		List<EmployeeInfo> empList = null;
		try {
			Query query = entityManager.createQuery(
					"from EmployeeInfo where email_Id=:email_Id or first_Name=:first_Name or last_Name=:last_Name or date_trunc('day',dob) =:dob")
					.setParameter("email_Id", empInfo.getEmailId()).setParameter("first_Name", empInfo.getFirstName())
					.setParameter("last_Name", empInfo.getLastName()).setParameter("dob", empInfo.getDateOfBirth());
			empList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}

	@Override
	public List<EmployeeInfo> getAllRecords() {
		List<EmployeeInfo> empList = null;
		try {
			// Query query=entityManager.createQuery("from EmployeeInfo emp join fetch
			// emp.listAddress add ");
			Query query = entityManager.createQuery(
					"Select emp from EmployeeInfo emp join fetch emp.listAddress as addres where addres.houseName=:house_name")
					.setParameter("house_name", "Welcome");
			
			empList = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}

	@Override
	public String update(Integer emdId, EmployeeInfo employeeInfo) {

		try {
			Query query = entityManager
					.createQuery("update from EmployeeInfo emp set emp.firstName=:firstName where emdId=:emdId")
					.setParameter("firstName", employeeInfo.getFirstName()).setParameter("emdId", emdId);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "update element";
	}

	@Override
	public EmployeeInfo getEmpInfoId(Integer empId) {
		List<EmployeeInfo> emplist = new ArrayList();
		try {
			Query query = entityManager.createQuery("from EmployeeInfo where emd_id=:emd_id").setParameter("emd_id",
					empId);
			emplist = query.getResultList();
			if (emplist != null) {
				for (EmployeeInfo emp : emplist) {
					for (Address address : emp.getListAddress()) {
						System.out.println(address.getHouseName());
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
