package pl.idczak.warehouseman2.transporter;

public class TransporterMapper {

    static TransporterDto toDto(Transporter entity){
        TransporterDto dto = new TransporterDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setCompany(entity.getCompany());
        dto.setVehicleNumber(entity.getVehicleNumber());
        return dto;
    }

    static Transporter toEntity(TransporterDto dto){
        Transporter entity = new Transporter();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setCompany(dto.getCompany());
        entity.setVehicleNumber(dto.getVehicleNumber());
        return entity;
    }

}
