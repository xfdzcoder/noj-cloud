//package io.github.xfdzcoder.noj.framework.sandbox.java.executor;
//
//import cn.hutool.dfa.WordTree;
//import cn.hutool.json.JSONUtil;
//import io.github.xfdzcoder.noj.framework.sandbox.java.ExitTypeEnum;
//import io.github.xfdzcoder.noj.framework.sandbox.java.JavaCodeExecutor;
//import io.github.xfdzcoder.noj.framework.sandbox.java.Param;
//import io.github.xfdzcoder.noj.framework.sandbox.java.Result;
//import io.github.xfdzcoder.noj.framework.sandbox.java.complier.Compiler;
//import io.github.xfdzcoder.noj.framework.sandbox.java.complier.CompilerException;
//import io.github.xfdzcoder.noj.framework.sandbox.java.complier.MemoryToFileCompiler;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.IOException;
//import java.net.URISyntaxException;
//import java.net.URL;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//
//
///**
// * 默认的 Java 代码执行器
// *
// * @author: xfdzcoder
// */
//
//public abstract class AbstractJavaExecutor implements JavaCodeExecutor {
//
//    private static final Logger LOG = LoggerFactory.getLogger(AbstractJavaExecutor.class);
//
//    private static final Compiler COMPILER = new MemoryToFileCompiler();
//
//    private static final WordTree BLACK_TREE = new WordTree();
//
//    private static final String BLACK_LIST_FILENAME = "black_list.json";
//
//    public AbstractJavaExecutor() {
//        URL url = AbstractJavaExecutor.class.getClassLoader().getResource(BLACK_LIST_FILENAME);
//        try {
//            Objects.requireNonNull(url);
//            String json = Files.readString(Paths.get(url.toURI()));
//            List<String> wordList = JSONUtil.parseArray(json).stream()
//                    .map(String::valueOf)
//                    .toList();
//            BLACK_TREE.addWords(wordList);
//            LOG.info(BLACK_TREE.toString());
//
//        } catch (IOException | URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public <I, O> Result<I, O> execute(Param<I, O> param) {
//        Objects.requireNonNull(param);
//        Objects.requireNonNull(param.getType());
//        boolean isSafe = check(param.getCode(), param.getExtraParam());
//        if (!isSafe) {
//            return new Result<>(ExitTypeEnum.NO_PERMISSION);
//        }
//        try {
//            Class<?> clz = compiler(param);
//
//            if (param.getType().isAcm()) {
//                return executeAcm(clz, param);
//            } else {
//                return executeCoreMethod(clz, param);
//            }
//        } catch (CompilerException e) {
//            return Result.<I, O>builder()
//                    .throwableOutput(e.getLocalizedMessage())
//                    .exitType(ExitTypeEnum.COMPILE_ERROR)
//                    .build();
//        } catch (ExecuteException e) {
//            return Result.<I, O>builder()
//                    .throwableOutput(e.getLocalizedMessage())
//                    .exitType(ExitTypeEnum.RUN_ERROR)
//                    .build();
//        }
//
//    }
//
//    protected boolean check(String code, Map<Object, Object> extraMap) {
//        return BLACK_TREE.match(code) == null;
//    }
//
////    @Override
////    public <I, O> Result<I, O> executeAcm(Class<?> clz, Param<I, O> param) throws ExecuteException {
////        try {
////            Method method = clz.getMethod("Main", String[].class);
////            PipedOutputStream in = new PipedOutputStream();
////            PipedInputStream out = new PipedInputStream();
////            System.setIn(new PipedInputStream(in));
////            System.setOut(new PrintStream(new PipedOutputStream(out), true, StandardCharsets.UTF_8));
////            List<InputOutput<I, O>> inputOutputs = param.getInputOutputList();
////            Result.ResultBuilder<Object, Object> builder = Result.builder();
////            long totalTime = 0;
////
////            for (int i = 0; i < inputOutputs.size(); i++) {
////                InputOutput<I, O> inputOutput = inputOutputs.get(i);
////                I input = inputOutput.getInput();
////                O exceptOutput = inputOutput.getOutput();
////
////                FutureTask<Long> futureTask = run(input, in, method);
////                totalTime += futureTask.get(param.getTimeout(), TimeUnit.MILLISECONDS);
////
////                String output = new String(out.readAllBytes(), StandardCharsets.UTF_8);
////                if (!exceptOutput.equals(output)) {
////                    throw new ExecuteException(i, input, output, exceptOutput);
////                }
////            }
////
////
////            return null;
////
////        } catch (NoSuchMethodException | IOException | ExecutionException | InterruptedException e) {
////            throw new ExecuteException(e);
////        } catch (TimeoutException e) {
////            return Result.<I, O>builder()
////                    .throwableOutput("超出时间限制")
////                    .exitType(ExitTypeEnum.TIMEOUT)
////                    .build();
////        }
////    }
//
////    private <I> FutureTask<Long> run(I input, PipedOutputStream in, Method method) {
////        Callable<Long> task = () -> {
////
////            long startTime = System.currentTimeMillis();
////            if (input != null) {
////                in.write(input.toString().getBytes(StandardCharsets.UTF_8));
////            }
////            method.invoke(null, (Object) null);
////            long endTime = System.currentTimeMillis();
////            return endTime - startTime;
////        };
////
////        return new FutureTask<>(task);
////    }
//
//    @SuppressWarnings("unchecked")
//    protected <I, O> Class<?> compiler(Param<I, O> param) throws CompilerException {
////        Object compileOption = param.getExtraParam().get("compile_option");
////        if (compileOption instanceof Iterable<?> options) {
////            return COMPILER.compiler(param.getCode(), (Iterable<String>) options);
////        } else {
////            return COMPILER.compiler(param.getCode());
////        }
//        return null;
//    }
//}
