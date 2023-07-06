package cn.crabapples.common.base;//package cn.crabapples.common.base;
//
//
//import org.example.application.common.DIC;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.data.repository.NoRepositoryBean;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@NoRepositoryBean
//public interface BaseRepository<T extends BaseEntity, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
//    @Override
//    default long count() {
//        return countByDelFlag(DIC.NOT_DEL);
//    }
//
//    long countByDelFlag(Integer delFlag);
//
//    default List<T> findByIds(List<ID> ids) {
//        return findByIdIn(ids);
//    }
//
//    default List<T> findByIds(ID[] ids) {
//        List<ID> list = Arrays.stream(ids).collect(Collectors.toList());
//        return findByIds(list);
//    }
//
//    //    List<T> findByDelFlagAndIdIn(Integer delFlag, List<ID> ids);
//    List<T> findByIdIn(List<ID> ids);
//
////    @Override
////    default Optional<T> findById(ID id) {
////        return findByDelFlagAndId(DIC.NOT_DEL, id);
////    }
//
//    Optional<T> findByDelFlagAndId(Integer delFlag, ID id);
//
////    @Override
////    default List<T> findAll() {
////        return findAll();
//////        return findByDelFlag(DIC.NOT_DEL);
////    }
//
//    List<T> findByDelFlag(Integer delFlag);
//
//    @Override
//    default Page<T> findAll(Pageable pageable) {
//        return findByDelFlag(pageable, DIC.NOT_DEL);
//    }
//
//    Page<T> findByDelFlag(Pageable pageable, Integer delFlag);
//
//    default void deleteLogicById(ID id) {
//        Optional<T> optional = findById(id);
//        optional.ifPresent(e -> {
//            e.setDelFlag(DIC.IS_DEL);
//            saveAndFlush(e);
//        });
//    }
//}
