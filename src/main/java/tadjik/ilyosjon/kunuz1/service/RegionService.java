package tadjik.ilyosjon.kunuz1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tadjik.ilyosjon.kunuz1.dto.RegionDto;
import tadjik.ilyosjon.kunuz1.model.Region;
import tadjik.ilyosjon.kunuz1.model.Result;
import tadjik.ilyosjon.kunuz1.repository.RegionRepo;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    @Autowired
    RegionRepo regionRepo;

    //get all region
    public List<Region> getall(){return regionRepo.findAll();}

    //get by id
    public Region getbyid(Integer id){
        Optional<Region> regionOptional = regionRepo.findById(id);
        return regionOptional.get();
    }
    //create
    public Result creat(RegionDto regionDto){

        Region region = new Region();
        region.setOrder_num(regionDto.getOrder_num());
        region.setName_eng(regionDto.getName_eng());
        region.setName_uz(regionDto.getName_uz());
        region.setName_ru(regionDto.getName_ru());
        regionRepo.save(region);
        return new Result(true, "Created");
    }

    public Result update(Integer id, RegionDto regionDto){
        Optional<Region> optionalRegion = regionRepo.findById(id);
        if (optionalRegion.isPresent()){
            Region region = optionalRegion.get();
            region.setOrder_num(regionDto.getOrder_num());
            region.setName_ru(regionDto.getName_ru());
            region.setName_eng(regionDto.getName_eng());
            region.setName_uz(regionDto.getName_uz());
            regionRepo.save(region);
            return new Result(true, "Updated");
        }
        return new Result(false, "Region not found");
    }

    public Result delet(Integer id){
        regionRepo.deleteById(id);
        return new Result(true, "Deleted");
    }
}
